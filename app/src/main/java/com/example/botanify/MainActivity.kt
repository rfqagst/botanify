package com.example.botanify

import android.Manifest
import android.app.PendingIntent.OnFinished
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.botanify.data.datastore.OnboardingManager
import com.example.botanify.screen.auth.AuthViewModel
import com.example.botanify.screen.auth.login.ForgotPassword
import com.example.botanify.screen.auth.login.LoginScreen
import com.example.botanify.screen.auth.register.RegisterScreen
import com.example.botanify.screen.home.HomeScreen
import com.example.botanify.screen.home.HomeViewModel
import com.example.botanify.screen.informasi.DetailInformasiScreen
import com.example.botanify.screen.informasi.ListInformasiScreen
import com.example.botanify.screen.navigation.NavGraph
import com.example.botanify.screen.navigation.Screen
import com.example.botanify.screen.notifikasi.NotificationScreen
import com.example.botanify.screen.onboarding.OnBoarding
import com.example.botanify.screen.scan.HasilScanScreen
import com.example.botanify.screen.scan.ScanTanamanScreen
import com.example.botanify.screen.search.DetailTanamanScreen
import com.example.botanify.screen.search.PlantViewModel
import com.example.botanify.screen.search.SearchInformationScreen
import com.example.botanify.screen.search.SearchTanamanScreen
import com.example.botanify.screen.search.profile.ProfileScreen
import com.example.botanify.screen.tanamansaya.ListTanamanSayaScreen
import com.example.botanify.screen.tanamansaya.TambahKoleksiTanamanScreen
import com.example.botanify.ui.theme.BotanifyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val onboardingManager by lazy { OnboardingManager(this) }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, 0
            )
        }

        val authViewModel: AuthViewModel by viewModels()
        setContent {
            BotanifyTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.OnBoarding.route) {
                        composable(Screen.OnBoarding.route) {
                            OnBoarding(
                                onboardingManager = onboardingManager,
                                onFinish = {
                                    navController.navigate(Screen.Login.route) {
                                        popUpTo(Screen.OnBoarding.route) { inclusive = true }
                                    }
                                }
                            )
                        }
                        composable(Screen.Register.route){
                            val authViewModel: AuthViewModel = hiltViewModel()
                            RegisterScreen(modifier = Modifier, navController, authViewModel)
                        }
                        composable(route = Screen.Login.route) {
                            val authViewModel: AuthViewModel = hiltViewModel()
                            LoginScreen(Modifier, navController, authViewModel)
                        }
                    }
                }

            }
        }
    }

    private fun hasRequiredPermissions(): Boolean {
        return REQUIRED_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                applicationContext,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    companion object {
        private val REQUIRED_PERMISSIONS = mutableListOf(
            Manifest.permission.CAMERA
        ).apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                add(Manifest.permission.POST_NOTIFICATIONS)
            }
        }.toTypedArray()
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BotanifyTheme {
    }
}