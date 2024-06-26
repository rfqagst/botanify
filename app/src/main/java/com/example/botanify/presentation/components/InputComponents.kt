package com.example.botanify.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botanify.R
import com.example.botanify.presentation.ui.theme.ContentWhite
import com.example.botanify.presentation.ui.theme.PrimaryBase
import com.example.botanify.presentation.ui.theme.SecondaryBase
import com.example.botanify.presentation.ui.theme.SurfaceBase

@Composable
fun NormalTextField(
    modifier: Modifier,
    titleTextField: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        var normalText by rememberSaveable {
            mutableStateOf("")
        }
        Text(
            text = titleTextField,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(ContentWhite),
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryBase,
                unfocusedBorderColor = Color.Transparent,
            ),
        )
    }
}

@Composable
fun DescriptionTextField(
    modifier: Modifier,
    titleTextField: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        Text(
            text = titleTextField,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(ContentWhite)
                .height(100.dp)
            ,
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryBase,
                unfocusedBorderColor = Color.Transparent,
            ),
        )
    }
}

@Composable
fun NormalTextFieldGreen(
    modifier: Modifier,
    titleTextField: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        var normalText by rememberSaveable {
            mutableStateOf("")
        }
        Text(
            text = titleTextField,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 24.sp,
                color = Color(0XFF142A3B),
                fontWeight = FontWeight(400),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(ContentWhite),
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryBase,
                unfocusedBorderColor = PrimaryBase,
            ),
        )
    }
}

@Composable
fun IconTextField(
    modifier: Modifier,
    titleTextField: String,
    value: String,
    onValueChange: (String) -> Unit,
    iconTextField: Painter
) {
    Column(modifier = modifier) {
        var normalText by rememberSaveable {
            mutableStateOf("")
        }

        Text(
            text = titleTextField,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(

            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp),
                    painter = iconTextField,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(ContentWhite, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp),
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryBase,
                unfocusedBorderColor = Color.Transparent,
            ),
        )
    }

}

@Composable
fun PasswordtTextField(
    modifier: Modifier,
    titleTextField: String,
    iconTextField: Painter,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        var normalText by rememberSaveable {
            mutableStateOf("")
        }

        var passwordVisibility by remember {
            mutableStateOf(false)
        }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.baseline_visibility_24)
        else
            painterResource(id = R.drawable.baseline_visibility_off_24)
        Text(
            text = titleTextField,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(

            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp),
                    painter = iconTextField,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(ContentWhite, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp),
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryBase,
                unfocusedBorderColor = Color.Transparent,
            ),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = icon,
                        contentDescription = "vis"
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()

        )
    }
}

@Composable
fun PasswordtTextFieldGreen(
    modifier: Modifier,
    titleTextField: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        var normalText by rememberSaveable {
            mutableStateOf("")
        }

        var passwordVisibility by remember {
            mutableStateOf(false)
        }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.baseline_visibility_24)
        else
            painterResource(id = R.drawable.baseline_visibility_off_24)
        Text(
            text = titleTextField,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 24.sp,
                color = Color(0XFF142A3B),
                fontWeight = FontWeight(400),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(ContentWhite, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp),
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryBase,
                unfocusedBorderColor = PrimaryBase,
            ),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = icon,
                        contentDescription = "vis"
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()

        )
    }
}



@Composable
fun DateTimeField(
    modifier: Modifier,
    titleTextField: String,
    value: String,
    onValueChange: (String) -> Unit,
    onClickIcon: () -> Unit,
    icon : ImageVector
) {
    Column(modifier = modifier) {
        Text(
            text = titleTextField,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(ContentWhite),
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryBase,
                unfocusedBorderColor = Color.Transparent,
            ),
            trailingIcon = {

                IconButton(onClickIcon) {
                    Icon(imageVector = icon, contentDescription = null, tint = SecondaryBase)
                }

            }

        )
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewInputComponents() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(SurfaceBase),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        NormalTextField(
//            modifier = Modifier,
//            titleTextField = "Nama Tanaman"
//        )
//        NormalTextFieldGreen(modifier = Modifier,
//            titleTextField = "", value = "") {
//
//        }

//        IconTextField(
//            modifier = Modifier,
//            titleTextField = "Email",
//            iconTextField = painterResource(id = R.drawable.ic_person_input)
//        )

//        PasswordtTextField(
//            modifier = Modifier, titleTextField = "Password", iconTextField = painterResource(
//                id = R.drawable.ic_lock
//            )
//        )
//        PasswordtTextFieldGreen(modifier = Modifier,
//            titleTextField ="" , value ="" ) {
//
//        }
        Spacer(modifier = Modifier.height(20.dp))


    }
}