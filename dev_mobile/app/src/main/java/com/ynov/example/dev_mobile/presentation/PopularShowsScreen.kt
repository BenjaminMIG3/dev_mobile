package com.ynov.example.dev_mobile.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.ynov.example.dev_mobile.domain.TvShow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularShowsScreen(
    onShowClick: (String) -> Unit,
    viewModel: PopularShowsViewModel = hiltViewModel()
) {
    val shows by viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TV Shows") }, // Titre de l'application
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Deux colonnes fixes
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), // Respecte la TopAppBar
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(shows) { show ->
                TvShowItem(
                    show = show,
                    onClick = { onShowClick(show.id.toString()) }
                )
            }
        }
    }
}

@Composable
fun TvShowItem(show: TvShow, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Ombre légère
        shape = MaterialTheme.shapes.medium // Coins arrondis
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp) // Padding interne dans la carte
        ) {
            AsyncImage(
                model = show.imageUrl,
                contentDescription = show.name,
                modifier = Modifier
                    .size(150.dp) // Taille fixe pour uniformité
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = show.name,
                style = MaterialTheme.typography.titleMedium, // Style Material3 pour le titre
                maxLines = 2,
                overflow = TextOverflow.Ellipsis, // Ajoute "..." si le texte est trop long
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}