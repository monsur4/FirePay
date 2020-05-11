package com.silicon.hub.firepay;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 1)

public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase instance;

    public abstract UserDao userDao();

    public abstract TransactionDao transactionDao();

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, UserDatabase.class, "user_database")
                    .fallbackToDestructiveMigration()
                    // .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabaseAsyncTask(instance).execute();
        }
    };

    private static class PopulateDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {
        UserDao userDao;

        private PopulateDatabaseAsyncTask(UserDatabase userDatabase) {
            this.userDao = userDatabase.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDao.insert(new User("tunjidaniels@yahoo.com", "tunjidaniels"));
            return null;
        }
    }
}
