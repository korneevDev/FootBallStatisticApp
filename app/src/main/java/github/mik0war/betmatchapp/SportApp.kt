package github.mik0war.betmatchapp

import android.app.Application
import github.mik0war.betmatchapp.di.ApplicationComponent
import github.mik0war.betmatchapp.di.DaggerApplicationComponent

class SportApp : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}