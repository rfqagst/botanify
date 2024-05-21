package com.example.botanify.screen.tanamansaya

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.botanify.R
import com.example.botanify.screen.components.DateTimeField
import com.example.botanify.screen.components.LargeBtn
import com.example.botanify.screen.components.NormalTextField
import com.example.botanify.screen.components.SmallBtn
import com.example.botanify.ui.theme.ContentWhite
import com.example.botanify.ui.theme.SurfaceBase

@Composable
fun TambahKoleksiTanamanScreen(modifier: Modifier) {

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            selectedImageUri = uri
        }

    val context = LocalContext.current


    Column(
        modifier
            .background(SurfaceBase)
            .padding(16.dp)
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

        NormalTextField(modifier = Modifier, titleTextField = "Nama Tanaman" )
        Spacer(modifier = Modifier.height(16.dp))

        DateTimeField(
            modifier = Modifier,
            titleTextField = "Durasi Penyiraman",
            datetime = "Hari"
        )
        Spacer(modifier = Modifier.height(16.dp))

        DateTimeField(
            modifier = Modifier,
            titleTextField = "Waktu Penyiraman",
            datetime = "Jam"
        )
        Spacer(modifier = Modifier.height(78.dp))

        LargeBtn(
            text = "Tambah Koleksi",
            onClick = { Toast.makeText(context, "Berhasil Menambahkan Koleksi Tanaman Baru", Toast.LENGTH_SHORT).show() },
            modifier = Modifier
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview() {
    TambahKoleksiTanamanScreen(modifier = Modifier)
}

