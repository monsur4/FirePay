package com.silicon.hub.firepay;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.room.Update;

import java.util.concurrent.ExecutionException;

public class FirePayRepository {
private static final String LOG_TAG = FirePayRepository.class.getSimpleName();

    private UserDao userDao;
    private static User currentUser;
    private TransactionDao transactionDao;

    public FirePayRepository(Application application) {
        Log.d(LOG_TAG, "Getting the repository");
        UserDatabase database = UserDatabase.getInstance(application);
        userDao = database.userDao();
        transactionDao = database.transactionDao();
    }

    public void insert(User user) {
        new InsertUserAsyncTask(userDao).execute(user);
    }

    public void update(User user) {
        new UpdateUserAsyncTask(userDao).execute(user);
    }

    public void delete(User user) {
        new DeleteUserAsyncTask(userDao).execute(user);
    }

    public void deleteAllUser() {

    }

    public User checkLoginCredentials(String email, String password) {
        try {
            currentUser = new CheckLoginCredentialsAsyncTask(userDao).execute(email, password).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentUser;
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        private InsertUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        private UpdateUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        private DeleteUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }

    private static class CheckLoginCredentialsAsyncTask extends AsyncTask<String, Void, User> {

        private UserDao userDao;

        private CheckLoginCredentialsAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected User doInBackground(String... strings) {
            User user = userDao.checkLoginCredentials(strings[0], strings[1]);
            return user;
        }
    }

    /**
     * The following lines of code will handle syncing of the transaction history from the online database
     * with that on the local database.
     * The code will read the online database, and the local database. Then it would compare the values,
     * to determine if both are the same. If they are different, it would clear the local database and update it.
     * Then it would read the transaction history from the local database.
     * But this comparison will only be done if there is network available, if there is no network, then a toast
     * message comes up that says network is unavailable(if this can be achieved), or "simply something went wrong."
     * however it would go ahead and read what is available from the local database.
     *
     * ##This will be done when ever the user clicks to view the transaction history??
     */


}
