package pl.lborowy.supercv;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.supercv.Fragment.ContactFragment;
import pl.lborowy.supercv.Fragment.ExperienceFragment;
import pl.lborowy.supercv.Fragment.NotesFragment;
import pl.lborowy.supercv.Fragment.SkillsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.navigationView)
    NavigationView navigationView;

//    @BindView(R.id.textViewphoneNumber)
//    TextView phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();

        // przechodzenie z menu do kontenrów
        navigationView.setNavigationItemSelectedListener(this);

//        openFragment(ContactFragment.newInstance());


//        CvRow phoneRow = new CvRow(this, "(+48) 692 449 800", R.drawable.icc_local_phone_black_24dp);
//        container.addView(phoneRow);
//
//        CvRow mailRow = new CvRow(this, "lucas.borowy@gmail.com", R.drawable.icc_email_black_24dp);
//        container.addView(mailRow);
//
//        CvRow webRow = new CvRow(this, "www.google.com", R.drawable.ic_public_black_24dp);
//        container.addView(webRow);
//
//        phoneRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                makeCall();
//            }
//        });
//
//        mailRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendMail();
//            }
//        });
//
//        webRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openWebsite();
//            }
//        });

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        navigationView.getMenu().performIdentifierAction(R.id.menu_contact, 0);
    }

    private void setupToolbar() {
        // nowy toolbar zajmuje się tak jak poprzedni
        setSupportActionBar(toolbar);

        // hamburger (this, drawerLayout, toolbar, text dla os z dys ON, text dla os z dys OFF)
        ActionBarDrawerToggle hamburger =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(hamburger);
        hamburger.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.menu_contact) {
//                    getSupportFragmentManager() //wspomaganie starszych wersji
//                            .beginTransaction()
//                            .replace(R.id.container, ContactFragment.newInstance())
//                            .commit();
//                }
//                else if (item.getItemId() == R.id.menu_skills) {
//                    getSupportFragmentManager() //wspomaganie starszych wersji
//                            .beginTransaction()
//                            .replace(R.id.container, SkillsFragment.newInstance())
//                            .commit();
//                }
//                else if (item.getItemId() == R.id.menu_experience) {
//
//                }
        toolbar.setTitle(item.getTitle()); // tytuł itemka
        item.setChecked(true); // podswietla w menu itemki

        openFragment(item);
        drawerLayout.closeDrawer(Gravity.LEFT);
        return false;
    }


    private void openFragment(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_contact:
                openFragment(ContactFragment.newInstance());
                break;
            case R.id.menu_skills:
                openFragment(SkillsFragment.newInstance());
                break;
            case R.id.menu_experience:
                openFragment(ExperienceFragment.newInstance());
                break;
            case R.id.menu_notes:
                openFragment(NotesFragment.newInstance());
                break;
        }
    }

    private void openFragment(Fragment fragment) {
        // builder - zamien jedno z drugim i wywołaj
        getSupportFragmentManager() //wspomaganie starszych wersji
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

}
