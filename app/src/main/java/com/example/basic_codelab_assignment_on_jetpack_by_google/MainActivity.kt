package com.example.basic_codelab_assignment_on_jetpack_by_google

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basic_codelab_assignment_on_jetpack_by_google.ui.theme.BasiccodelabassignmentonjetpackbygoogleTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasiccodelabassignmentonjetpackbygoogleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MyApp()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
val expanded = remember{ mutableStateOf(false) }
        val extraPadding = if (expanded.value) 48.dp else 0.dp

    val buttonText = if (expanded.value) "show less" else "show more"

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxWidth()
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello ")
                Text(text = name)
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value
            Log.i("expanded","button clicked ${expanded.value}")}) {
                Text(text = buttonText)
            }
        }
    }
}


@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}





@Composable

private fun Greetings(
    modifier: Modifier = Modifier,
    names: List <String> = List(1000){"$it"}
) {
    LazyColumn(modifier =Modifier.padding(vertical = 4.dp)){
        items(items = names){name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Android Basics Codelab by google performed by romitp4l")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 320 , uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OnboardingPreview() {
    BasiccodelabassignmentonjetpackbygoogleTheme{
        OnboardingScreen(modifier = Modifier, onContinueClicked = {})
    }
}




@Preview
@Composable
fun GreetingsPreview(
) {
    BasiccodelabassignmentonjetpackbygoogleTheme {
        Greetings(modifier = Modifier.padding(24.dp))

    }
}

@Preview(showBackground = true, showSystemUi = false, widthDp = 320)
@Composable
fun GreetingPreview() {
    BasiccodelabassignmentonjetpackbygoogleTheme {
        Greeting("romitp4l")
    }
}

//@Preview
//@Composable
//fun HomeScreen(
//
//) {
//
//    BasiccodelabassignmentonjetpackbygoogleTheme {
//        Column {
//            MyAppPreview()
//
//
//            Spacer(modifier = Modifier.height(50.dp))
//
//            GreetingPreview()
//        }
//    }
//}