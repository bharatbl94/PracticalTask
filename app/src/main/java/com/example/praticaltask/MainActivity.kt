package com.example.praticaltask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.praticaltask.screens.MainScreenView
import com.example.praticaltask.ui.theme.PraticalTaskTheme
import com.example.praticaltask.utils.Utils
import com.example.praticaltask.viewModels.MainViewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lastTimeSaved = Utils.getLastTimePreference(this)
        val apiKey = getString(R.string.app_id)
        lastTimeSaved?.let { mainViewModel.checkAndFetchCurrencyData(it, apiKey) }
        enableEdgeToEdge()
        setContent {
            PraticalTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    MainScreenView(viewModel = mainViewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PraticalTaskTheme {
        Greeting("Android")
    }
}