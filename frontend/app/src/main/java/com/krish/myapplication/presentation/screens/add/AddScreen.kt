package com.krish.myapplication.presentation.screens.add

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddScreen(
    navController: NavHostController
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Add Note")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Arrow",
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { navController.navigateUp() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Back Arrow",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            var title by remember { mutableStateOf(TextFieldValue("")) }
            var body by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Enter Title") },
                value = title,
                onValueChange = {
                    title = it
                }
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(12.dp)
                .padding(paddingValues))

            OutlinedTextField(
                modifier = Modifier.fillMaxSize(),
                label = { Text(text = "Enter Body") },
                value = body,
                onValueChange = {
                    body = it
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    AddScreen(navController = rememberNavController())
}