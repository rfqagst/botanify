package com.example.botanify.presentation.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botanify.presentation.components.LargeBtn
import com.example.botanify.presentation.components.NormalTextFieldGreen

@Composable
fun EditProfileScreen (modifier: Modifier){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column (modifier.padding(start = 22.dp, end = 22.dp, top = 80.dp)){
        NormalTextFieldGreen(modifier = Modifier,
            titleTextField ="Nama" ,
            value = name,
            onValueChange = {name = it})
        Spacer(modifier = Modifier.height(32.dp))
        NormalTextFieldGreen(modifier = Modifier,
            titleTextField ="Email" ,
            value =email,
            onValueChange = {email = it})
        Spacer(modifier = Modifier.height(60.dp))
        LargeBtn(text = "Simpan",
            onClick = { /*TODO*/ },
            modifier = Modifier)
    }
}
@Composable
@Preview(showBackground = true)
fun PreviewEditProfile() {
    Column(modifier = Modifier.fillMaxSize()) {
        EditProfileScreen(modifier = Modifier)

    }

}