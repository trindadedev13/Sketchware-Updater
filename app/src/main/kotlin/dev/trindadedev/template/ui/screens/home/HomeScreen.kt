package dev.trindadedev.template.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.input.nestedscroll.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*

import dev.trindadedev.template.Strings
import dev.trindadedev.template.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
  val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
  val scrollState = rememberScrollState()

  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      TopBar(
        title = { Text(stringResource(id = Strings.app_name)) },
        scrollBehavior = scrollBehavior,
      )
    },
  ) { innerPadding ->
    Column(
      Modifier
        .padding(innerPadding)
        .verticalScroll(scrollState)
    ) {
      
    }
  }
}