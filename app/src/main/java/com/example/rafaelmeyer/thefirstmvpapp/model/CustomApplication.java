package com.example.rafaelmeyer.thefirstmvpapp.model;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * Created by rafael.meyer on 10/14/16.
 */
public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration.Builder realmConfiguration = new RealmConfiguration.Builder(this)
                .name("myapp.realm")
                .schemaVersion(0)
                .migration(new RealmMigration() {
                    @Override
                    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

                    }
                });

        Realm.setDefaultConfiguration(realmConfiguration.build());
    }
}
