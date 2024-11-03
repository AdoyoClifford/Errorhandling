package com.adoyo.errorhandlingclass.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adoyo.errorhandlingclass.ui.theme.ErrorHandlingCLassTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Column {
          TextField(
              value = "",
              onValueChange = {},
              label = { Text("Enter a email") }
          )
          Spacer(modifier = Modifier.height(16.dp))
          TextField(
              value = "",
              onValueChange = {},
              label = { Text("Enter a number") }
          )
      }

    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    ErrorHandlingCLassTheme { HomeScreen() }

}