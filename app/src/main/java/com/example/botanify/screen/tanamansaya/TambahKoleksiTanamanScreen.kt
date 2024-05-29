package com.example.botanify.screen.tanamansaya

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.botanify.data.model.PlantCollection
import com.example.botanify.data.model.Reminder
import com.example.botanify.screen.alarmnotification.NotificationPenyiramanReceiver
import com.example.botanify.screen.components.DateTimeField
import com.example.botanify.screen.components.LargeBtn
import com.example.botanify.screen.components.NormalTextField
import com.example.botanify.screen.components.SmallBtn
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.PrimaryBase
import com.example.botanify.ui.theme.SurfaceBase
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
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahKoleksiTanamanScreen(
    modifier: Modifier,
    tanamanSayaViewModel: TanamanSayaViewModel,
) {

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var namaTanaman by remember { mutableStateOf("") }
    var durasiPenyiraman by remember { mutableStateOf("") }
    var waktuPenyiraman by remember { mutableStateOf("") }

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
            .fillMaxSize(),
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
            titleTextField = "Nama Tanaman",
            value = namaTanaman,
            onValueChange = { namaTanaman = it })
        Spacer(modifier = Modifier.height(16.dp))

        DateTimeField(
            modifier = Modifier,
            titleTextField = "Durasi Penyiraman",
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
        Spacer(modifier = Modifier.height(78.dp))

        LargeBtn(
            text = "Tambah Koleksi",
            onClick = {
                selectedImageUri?.let { uri ->
                    tanamanSayaViewModel.uploadImageToStorage(uri, context) { imageUrl ->
                        val reminder = Reminder(
                            dates = selectedDates.value.map { it.format(dateFormatter) },
                            time = selectedTime.value.toString()
                        )

                        val plantCollection = PlantCollection(
                            plantName = namaTanaman,
                            plantImage = imageUrl,
                            reminder = mapOf("reminder1" to reminder)
                        )

                        tanamanSayaViewModel.addKoleksiTanaman(
                            plantCollection
                        )
                    }
                }
            },
            modifier = Modifier
        )


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
                scheduleNotification(context, selectedDates.value, selectedTime.value)
                namaTanaman = ""
                durasiPenyiraman = ""
                waktuPenyiraman = ""
                selectedImageUri = null
                Text(
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 32.dp),
                    color = PrimaryBase,
                    text = "Berhasil Menambahkan Koleksi Tanaman"
                )
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


@RequiresApi(Build.VERSION_CODES.O)
fun scheduleNotification(
    context: Context,
    selectedDates: List<LocalDate>,
    selectedTime: LocalTime
) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, NotificationPenyiramanReceiver::class.java)

    selectedDates.forEach { date ->
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, date.year)
            set(Calendar.MONTH, date.monthValue - 1)
            set(Calendar.DAY_OF_MONTH, date.dayOfMonth)
            set(Calendar.HOUR_OF_DAY, selectedTime.hour)
            set(Calendar.MINUTE, selectedTime.minute)
            set(Calendar.SECOND, selectedTime.second)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            date.toEpochDay().toInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview() {
//    TambahKoleksiTanamanScreen(modifier = Modifier)
}

