package com.example.botanify.presentation.screen.tanamansaya

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.botanify.R
import com.example.botanify.presentation.components.DateTimeField
import com.example.botanify.presentation.components.DescriptionTextField
import com.example.botanify.presentation.components.LargeBtn
import com.example.botanify.presentation.components.NormalTextField
import com.example.botanify.presentation.components.SmallBtn
import com.example.botanify.presentation.screen.alarmnotification.scheduleNotification
import com.example.botanify.presentation.ui.theme.ContentWhite
import com.example.botanify.presentation.ui.theme.PrimaryBase
import com.example.botanify.presentation.ui.theme.SurfaceBase
import com.example.botanify.utils.Resource
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahKoleksiTanamanScreen(
    modifier: Modifier,
    tanamanSayaViewModel: TanamanSayaViewModel,
) {

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var namaTanaman by remember { mutableStateOf("") }
    var plantNote by remember { mutableStateOf("") }
    var durasiPenyiraman by remember { mutableStateOf("") }
    var waktuPenyiraman by remember { mutableStateOf("") }
    var isFormReset by remember { mutableStateOf(false) }

    val selectedDates = remember { mutableStateOf<List<LocalDate>>(listOf()) }
    val selectedTime = remember { mutableStateOf(LocalTime.of(0, 0, 0)) }

    val dateFormatter = DateTimeFormatter.ofPattern("MM-dd")

    val calenderState = rememberUseCaseState()

    val clockState = rememberUseCaseState()


    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            selectedImageUri = uri
        }

    val context = LocalContext.current

    val addPlantState by tanamanSayaViewModel.addPlantState.collectAsState()


    LaunchedEffect(addPlantState) {
        if (addPlantState is Resource.Success) {
            // Reset form fields
            selectedImageUri = null
            namaTanaman = ""
            durasiPenyiraman = ""
            waktuPenyiraman = ""
            plantNote = ""
            selectedDates.value = listOf()
            selectedTime.value = LocalTime.of(0, 0, 0)
        }
    }


    CalendarDialog(
        state = calenderState,
        config = CalendarConfig(
            monthSelection = true,
        ),
        selection = CalendarSelection.Dates(selectedDates = selectedDates.value) { dates ->
            selectedDates.value = dates
            durasiPenyiraman = dates.joinToString { it.format(dateFormatter) }
            Log.d("SelectedDates", durasiPenyiraman)
        }
    )


    ClockDialog(
        state = clockState,
        selection = ClockSelection.HoursMinutes { hours, minutes ->
            selectedTime.value = LocalTime.of(hours, minutes, 0)
            waktuPenyiraman = LocalTime.of(hours, minutes, 0).toString()
        },
        config = ClockConfig(
            defaultTime = selectedTime.value,
            is24HourFormat = true
        )
    )

    Column(
        modifier
            .background(SurfaceBase)
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), // Tambahkan ini untuk scrolling
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(185.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(ContentWhite), contentAlignment = Alignment.Center
        ) {

            if (selectedImageUri != null) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = rememberAsyncImagePainter(model = selectedImageUri),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

            } else {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier.size(45.dp),
                        painter = painterResource(id = R.drawable.ic_gallery),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SmallBtn(
                        text = "Unggah Foto",
                        onClick = { launcher.launch("image/*") },
                        modifier = Modifier
                    )
                }
            }


        }
        Spacer(modifier = Modifier.height(32.dp))

        NormalTextField(
            modifier = Modifier,
            titleTextField = "Nama Koleksi",
            value = namaTanaman,
            onValueChange = { namaTanaman = it })
        Spacer(modifier = Modifier.height(16.dp))

        DateTimeField(
            modifier = Modifier,
            titleTextField = "Durasi Reminder Aktif",
            value = durasiPenyiraman,
            onValueChange = { durasiPenyiraman = it },
            onClickIcon = {
                calenderState.show()
            },
            icon = Icons.Default.DateRange
        )
        Spacer(modifier = Modifier.height(16.dp))

        DateTimeField(
            modifier = Modifier,
            titleTextField = "Waktu Penyiraman",
            value = waktuPenyiraman,
            onValueChange = { waktuPenyiraman = it },
            onClickIcon = {
                clockState.show()
            },
            icon = Icons.Default.Alarm

        )


        Spacer(modifier = Modifier.height(16.dp))

        DescriptionTextField(
            modifier = Modifier,
            titleTextField = "Catatan Tanaman",
            value = plantNote,
            onValueChange = { plantNote = it })

        Spacer(modifier = Modifier.height(58.dp))

        LargeBtn(
            text = "Tambah Koleksi",
            onClick = {
                selectedImageUri?.let { uri ->
                    tanamanSayaViewModel.uploadImageAndCollectionToStorage(
                        uri = uri,
                        plantName = namaTanaman,
                        plantNote = plantNote,
                        selectedTime = selectedTime.value,
                        selectedDates = selectedDates.value,
                        context = context,
                    )
                }
            },
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(38.dp))


        when (addPlantState) {
            is Resource.Error -> {
                Text(
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 32.dp),
                    color = Color.Red,
                    text = "Berhasil Menambahkan Koleksi Tanaman"
                )
            }

            is Resource.Success -> {
                scheduleNotification(context, selectedDates.value, selectedTime.value, namaTanaman)
                Text(
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 32.dp),
                    color = PrimaryBase,
                    text = "Berhasil Menambahkan Koleksi Tanaman"
                )
                isFormReset = true
            }

            is Resource.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .size(48.dp)
                        .align(Alignment.CenterHorizontally)
                )

            }

            is Resource.Idle -> {
                // Do nothing
            }
        }


    }

}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview() {
//    TambahKoleksiTanamanScreen(modifier = Modifier)
}

