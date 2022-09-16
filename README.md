Rebtel Flags App
======================================================
A Sample application that shows a master-detail list of countries (via their flags and name).

App summary
-------------------------
I used MVVM architecture for this app. It's a pretty straight forward application and MVVM works best in cases like this.
The VM handles all the important logic and simply exposes a UI view state to the view. 
The view (the dumb part) simply needs to consume the view state and display the UI as instructed. 
As for the repository, I opted to include 2 data source (local and remote; DB and API). 
I first fetch the data remotely (Retrofit) then save a local (Room) copy. 
This way, whenever the user tries to access the app and have no connection, it will still have available data fetched locally.

I opted to use Glide to render the flag images (from url). I think this is better than storing all flag images locally.
This way, if ever there is a change/update, I wouldn't need to release an app-store update just to update the pngs. 
It'll work dynamically. Also Glide uses disk-caching which is resource efficient. 
(I understand that countries don't frequently update their flags, It's just purely hypthetical).

I've also added unit test coverage for important functions of the ViewModel and Repository class logic.

Issues / Challenges
-------------------------
Time was a bit tight on this one. I was only able to work on this during evenings or weekends.
I also promised to implement this using Coroutines and Jetpack Compose. 
Given the situation, my focus was getting the basic features done first then extras could follow. 
It also took a bit more time than expected to learn Compose (hence the very basic UI) and some complications in unit testing with Flow.

What could be improved
-------------------------
* UI / UX
* Additional test coverage
* Git workflow (for PRs and merges)

Libraries / concepts used
-------------------------
* MVVM app architecture
* Jetpack Compose - for UI layer
* Kotlin Coroutines & Kotlin Flow - for concurrency & reactive approach
* Livedata - Reactive
* Gson converter - for JSON parsing
* Retrofit - for networking
* Koin - for Dependency Injection pattern implementation
* Room - for local database
* SwipeRefresh (accompanist) - for pull to refresh list goodness
* Glide (landscapist) - for image loading
* Mockk - for Mocking (unit testing)
