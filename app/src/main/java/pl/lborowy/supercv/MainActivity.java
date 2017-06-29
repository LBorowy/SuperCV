package pl.lborowy.supercv;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.supercv.Fragment.ContactFragment;
import pl.lborowy.supercv.Fragment.EducationFragment;
import pl.lborowy.supercv.Fragment.ExperienceFragment;
import pl.lborowy.supercv.Fragment.NotesFragment;
import pl.lborowy.supercv.Fragment.PasswordFragment;
import pl.lborowy.supercv.Fragment.ProjectsFragment;
import pl.lborowy.supercv.Fragment.SkillsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.snackbar_attach)
    CoordinatorLayout snackBar;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.navigationView)
    NavigationView navigationView;

//    @BindView(R.id.textViewphoneNumber)
//    TextView phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // odpalanie XML'a z hasłem
        PasswordFragment.newInstance().show(getSupportFragmentManager(), "");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();

        // przechodzenie z menu do kontenrów
        navigationView.setNavigationItemSelectedListener(this);

        // odpalanie XML'a z hasłem
//        PasswordFragment.newInstance().show(getSupportFragmentManager(), "");

        // gdy klikamy w SNACKBARA
//        onFloatActionButtonClicked();

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

    @OnClick(R.id.fabContact)
    public void onFloatActionButtonClicked() {
//        Toast.makeText(this, "FloatActionButton2", Toast.LENGTH_SHORT).show();
        Snackbar.make(snackBar, "Test", Snackbar.LENGTH_SHORT).show();
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

    // do info
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //wypełniamy menu
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // LISTENER do INFO
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.options_info:
                //// TODO: 2017-06-28 new dialog
                showInfoDialog();
//                Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("klauzula")
                .setIcon(R.drawable.ic_check_black_24dp)
                .setMessage("Wyrażam zgodę na....")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // zamyka dialog (tutaj klasa anonimowa)
                    }
                });

//        builder.create().showInfoDialog();
        //lub
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
            case R.id.menu_education:
                openFragment(EducationFragment.newInstance());
                break;
            case R.id.menu_projects:
                openFragment(ProjectsFragment.newInstance());
                break;
            case R.id.menu_hobby:
                openFragment(ProjectsFragment.newInstance());
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
