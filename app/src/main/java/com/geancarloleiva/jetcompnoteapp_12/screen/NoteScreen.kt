package com.geancarloleiva.jetcompnoteapp_12.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geancarloleiva.jetcompnoteapp_12.R
import com.geancarloleiva.jetcompnoteapp_12.components.NoteButton
import com.geancarloleiva.jetcompnoteapp_12.components.NoteInputText
import com.geancarloleiva.jetcompnoteapp_12.model.Note
import java.time.format.DateTimeFormatter

@Composable
fun NoteScreen(
    lstNote: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    Column(modifier = Modifier.padding(6.dp)) {
        //TopBar
        TopBarApp()

        //Form
        NoteForm()

        Divider(modifier = Modifier.padding(10.dp))

        //List
        NoteList(lstNote)
    }
}

@Composable
fun TopBarApp() {
    TopAppBar(title = {
        Text(text = stringResource(id = R.string.app_name))
    }, actions = {
        Icon(
            imageVector = Icons.Rounded.Notifications,
            contentDescription = stringResource(id = R.string.app_name)
        )
    },
        backgroundColor = Color(0xFFDADFE3)
    )
}

@Composable
fun NoteForm(context: Context = LocalContext.current) {
    var title by remember {
        mutableStateOf("")
    }
    var detail by remember {
        mutableStateOf("")
    }
    var btnEnable by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Note title
        NoteInputText(
            modifier = Modifier.padding(
                top = 9.dp,
                bottom = 8.dp
            ),
            text = title,
            label = stringResource(id = R.string.txt_title),
            onTextChange = {
                title = it
                btnEnable = validateForm(title, detail)
            })
        //Note detail
        NoteInputText(
            modifier = Modifier.padding(
                top = 9.dp,
                bottom = 8.dp
            ),
            text = detail,
            label = stringResource(id = R.string.txt_detail),
            onTextChange = {
                detail = it
                btnEnable = validateForm(title, detail)
            })
        //Create button
        NoteButton(
            text = stringResource(id = R.string.btn_create),
            enabled = btnEnable,
            onClick = {
                Toast.makeText(
                    context, "Click",
                    Toast.LENGTH_SHORT
                ).show()
            })
    }
}

fun validateForm(title: String, detail: String): Boolean {
    return title.isNotEmpty() && title.isNotBlank()
            && detail.isNotEmpty() && detail.isNotBlank()
}

@Composable
fun NoteList(lstNote: List<Note>) {
    LazyColumn {
        items(lstNote) { note ->
            NoteRow(
                note = note,
                onNoteClicked = {})
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
    val datePattern = "EEE, d MMM"
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 22.dp, bottomStart = 22.dp))
            .fillMaxWidth(),
        color = Color(0xFF3F51B5),
        elevation = 6.dp
    ) {
        Column(modifier = modifier
            .clickable { }
            .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {
            //Title
            Text(
                text = note.title,
                style = MaterialTheme.typography.subtitle2
            )
            //Detail
            Text(
                text = note.detail,
                style = MaterialTheme.typography.subtitle1
            )
            //Entry date
            Text(
                text = note.entryDate
                    .format(DateTimeFormatter.ofPattern(datePattern)),
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(
        lstNote = emptyList(),
        onAddNote = {},
        onRemoveNote = {})
}