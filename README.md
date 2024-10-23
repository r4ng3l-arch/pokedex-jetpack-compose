# Pokedex Jetpack Compose App

A modern Pokedex app built using Jetpack Compose, following MVVM architecture, and integrating with the PokeAPI to display Pokémon details.

## Screenshots
![Pokedex Screenshot](https://github.com/r4ng3l-arch/pokedex-jetpack-compose/blob/main/previews/pokedex_example.png)

## Tech Stack & Open-source Libraries
- **Jetpack Compose**: For building declarative UI.
- **Koin**: Dependency injection framework.
- **Coroutines & Flow**: For managing asynchronous data streams.
- **Retrofit**: HTTP client for consuming the PokeAPI.
- **Coil**: For image loading.
- **Material3**: For Material Design 3 components.

## Architecture
This app is built using **MVVM (Model-View-ViewModel)** architecture, ensuring separation of concerns and maintainable code. The app communicates with a remote API (PokeAPI) to fetch data and display it in a modern, reactive UI.

- **ViewModel**: Manages UI-related data in a lifecycle-conscious way.
- **Repository**: Responsible for fetching data from the API and handling business logic.
- **PokeAPI**: Provides Pokémon details, including stats, types, and images.
- **StateFlow**: For managing and observing UI states.

## Open API
This app integrates with the [PokeAPI](https://pokeapi.co/), an open-source API that provides comprehensive information on Pokémon.

Key API endpoints:
- `/pokemon`: Retrieves a list of all Pokémon.
- `/pokemon/{id}`: Retrieves details about a specific Pokémon, including types, abilities, and sprites.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
