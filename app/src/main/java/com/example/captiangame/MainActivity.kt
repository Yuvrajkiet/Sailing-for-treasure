package com.example.captiangame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.captiangame.ui.theme.CaptianGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptianGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    game()
                }
            }
        }
    }
    @Composable
    fun game(){
        val context = LocalContext.current
        val treasureFound = remember { mutableStateOf(value = 0) }
        val direction = remember { mutableStateOf(value = "North") }

        Column (Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Tresures Found : ${treasureFound.value}")
            Text(text = "Currently moving in : ${direction.value}")
            Button(onClick = {
                direction.value = "East"
                if(Random.nextBoolean()){
                    Toast.makeText(context, "Treasure found!", Toast.LENGTH_SHORT).show()
                    treasureFound.value += 1
                }
                else{
                    Toast.makeText(context, "No treasure :(", Toast.LENGTH_SHORT).show()
                }
            }){
                Text("Sail East")
            }
            Button(onClick = {
                direction.value = "North"
                if(Random.nextBoolean()){
                    treasureFound.value += 1
                }
            }){
                Text("Sail North")
            }
            Button(onClick = {
                direction.value = "West"
                if(Random.nextBoolean()){
                    treasureFound.value += 1
                }
            }){
                Text("Sail West")
            }
            Button(onClick = {
                direction.value = "South"
                if(Random.nextBoolean()){
                    treasureFound.value += 1
                }
            }){
                Text("Sail South")
            }
        }
    }
}
