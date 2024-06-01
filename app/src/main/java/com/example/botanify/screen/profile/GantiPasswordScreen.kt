package com.example.botanify.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.screen.components.LargeBtn
import com.example.botanify.screen.components.NormalTextFieldGreen
import com.example.botanify.screen.components.PasswordtTextFieldGreen

@Composable
fun GantiPasswordScreen (modifier: Modifier){
    var oldPw by remember { mutableStateOf("") }
    var newPw by remember { mutableStateOf("") }
    var newPwVerif by remember { mutableStateOf("") }
    Column (modifier.padding(start = 22.dp, end = 22.dp, top = 80.dp)){
        PasswordtTextFieldGreen(modifier = Modifier,
            titleTextField ="Kata Sandi Lama" ,
            value = oldPw,
            onValueChange = {oldPw = it})
        Spacer(modifier = Modifier.height(32.dp))
        PasswordtTextFieldGreen(modifier = Modifier,
            titleTextField ="Kata Sandi Baru" ,
            value = newPw,
            onValueChange = {newPw = it})
        Spacer(modifier = Modifier.height(32.dp))
        PasswordtTextFieldGreen(modifier = Modifier,
            titleTextField ="Ulang Kata Sandi Baru" ,
            value = newPwVerif,
            onValueChange = {newPwVerif = it})
        Spacer(modifier = Modifier.height(60.dp))
        LargeBtn(text = "Ubah",
            onClick = { /*TODO*/ },
            modifier = Modifier
        )

    }
}
@Composable
@Preview(showBackground = true)
fun PreviewEditSandi() {
    Column(modifier = Modifier.fillMaxSize()) {
        GantiPasswordScreen(modifier = Modifier)

    }

}