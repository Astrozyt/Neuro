package com.gbl.neuro.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gbl.neuro.model.Recording

@Composable
fun ListOverview() {
    Column() {
        Text( text = "My recordings")

        Button(modifier = Modifier.padding(8.dp), onClick = { /*TODO*/ }) {
            Text("Start new recording")
        }

    }

}

@Composable
fun RecordingCard(recording: Recording, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Column() {
            Text(text = recording.name, modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall)
            Text(text = recording.date, modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall)
            Text(text = recording.location, modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall)
            Text(text = recording.description, modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall)
            Text(text = recording.rating.toString(),modifier=Modifier.fillMaxWidth().padding(vertical = 12.dp), textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun RecordingCardPreview() {
    RecordingCard(recording = Recording(1, "Test", 1, "Test", "Test", "Test", 1, "Test"))
}