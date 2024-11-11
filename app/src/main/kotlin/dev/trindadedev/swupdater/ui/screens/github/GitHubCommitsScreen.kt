package dev.trindadedev.swupdater.ui.screens.github

import androidx.compose.foundation.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.input.nestedscroll.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.platform.LocalUriHandler

import dev.trindadedev.swupdater.Strings
import dev.trindadedev.swupdater.ui.components.TopBar
import dev.trindadedev.swupdater.ui.screens.github.models.Commit

import org.koin.androidx.compose.koinViewModel

import coil3.compose.AsyncImage

import kotlinx.datetime.toJavaInstant

import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GitHubCommitsScreen() {
  val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
  val listState = rememberLazyListState()
  val viewModel = koinViewModel<HomeViewModel>()
  
  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      TopBar(
        title = { 
          Text(stringResource(id = Strings.label_github_commits))
        },
        scrollBehavior = scrollBehavior,
        isLarge = true
      )
    },
  ) { innerPadding ->
    CommitsList(
      modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize(),
      items = viewModel.commits,
      listState = listState 
    )
  }
}

@Composable
private fun CommitsList(
  modifier: Modifier = Modifier,
  items: List<Commit>,
  listState: LazyListState 
) {
  LazyColumn(
    modifier = modifier,
    state = listState
  ) {
    itemsIndexed(items) { index, item ->
      DynamicListItem(
        listLength = items.size - 1,
        currentValue = index
      ) {
        CommitItem(commit = item)
      }
    }
  }
}


@Composable
private fun CommitItem(
  commit: Commit
) {
  val uriHandler = LocalUriHandler.current
  Column(
    verticalArrangement = Arrangement.spacedBy(10.dp),
    modifier = Modifier
      .fillMaxWidth()
      .clickable {
        uriHandler.openUri(commit.url) 
      }
      .padding(16.dp)
  ) {
    Row(
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        AsyncImage(
          model = commit.info.author.avatar,
          contentDescription = commit.info.author.name,
          modifier = Modifier
            .size(20.dp)
            .clip(CircleShape)
        )
        Text(
          text = commit.info.author.name,
          style = MaterialTheme.typography.labelMedium
        )
      }
      Text(
        text =" •",
        style = MaterialTheme.typography.labelLarge
      )
      Text(
        text = commit.sha.substring(0, 7),
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.primary,
        fontFamily = FontFamily.Monospace
      )
      Text(
        text = SimpleDateFormat
          .getDateInstance(SimpleDateFormat.SHORT)
          .format(
            Date.from(commit.info.author.date.toJavaInstant())
          ),
        style = MaterialTheme.typography.labelMedium,
        color = LocalContentColor.current.copy(alpha = 0.5f),
        textAlign = TextAlign.End,
        modifier = Modifier.weight(1f)
      )
    }
    Text(
      text = commit.info.message.split("\n").first(),
      style = MaterialTheme.typography.labelLarge
    )
  }
}