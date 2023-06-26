package com.example.youtube_assignment3_20bce10389

import android.app.LauncherActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.youtube_assignment3_20bce10389.ui.theme.Youtube_Assignment3_20BCE10389Theme
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Youtube_Assignment3_20BCE10389Theme {
              RecyclerView(ids = listOf("pvNcJXprrKM","c6TJQixS51Y","jkZsSWF4tsw","cjP8hn_iIwI","mEc3TI3GcD4"))
            }
        }
    }
}
@Composable
fun ListItem(idd:String){
    var isClicked = remember {mutableStateOf(false)}
    Surface(color=MaterialTheme.colorScheme.primary, modifier=Modifier.padding(vertical=4.dp, horizontal = 8.dp)){
        Column(modifier= Modifier
            .padding(24.dp)
            .fillMaxWidth()){
            Row {
               OutlinedButton(onClick = {isClicked.value=!isClicked.value}) {
                   if(isClicked.value){
                   Text(text = "STOP VIDEO",color= Color.Black)}
                   else{
                       Text(text = "PLAY VIDEO",color= Color.Black)
                   }
               } 
                if(isClicked.value){
                    YoutubeScreen(videoId = idd)
                }
            }
        }
    }
}
@Composable 
fun RecyclerView(ids:List<String>){
    
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items=ids){id->
            ListItem(idd =id )
        }
    }
    
}
@Composable
fun YoutubeScreen(
    videoId: String,
) {
    val ctx = LocalContext.current
    AndroidView(factory = {
        var view = YouTubePlayerView(it)
        val fragment = view.addYouTubePlayerListener(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            }
        )
        view
    })
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Youtube_Assignment3_20BCE10389Theme {
        Greeting("Android")
    }
}