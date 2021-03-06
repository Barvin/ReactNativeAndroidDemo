package teamapp.id2212.ict.kth.se.teamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static ArrayList<String> courses = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        courses.add("Advanced Internetworking II  ( IK2217 ) ");
        courses.add("Developing Mobile Applications  ( ID2216 ) ");
        courses.add("Network Programming with Java  ( ID2212 ) ");
        courses.add("Computer Hardware Engineering ( ID1201 )");
        courses.add("Another course");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, courses);
        final AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.courses_list);
        textView.setAdapter(adapter);

        textView.setThreshold(0);

        findViewById(R.id.courses_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courseListSelected();
            }
        });

        findViewById(R.id.btn_addCourse).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int selectedCoursePos = textView.getListSelection();

            }
        });

        findViewById(R.id.searchMatches).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void courseListSelected(){
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.courses_list);
        textView.showDropDown();
    }

    public static ArrayList<String> getCourses() {
        return courses;
    }

    public static void setCourse(String courseName) {
        courses.add(courseName);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_courses) {
            Intent intent = new Intent(this, UserProfile.class);
            startActivity(intent);
        } else if (id == R.id.nav_personalprofile) {
            Intent intent = new Intent(this, PersonalProfile.class);
            startActivity(intent);
        } else if (id == R.id.nav_seeFeedback) {
            Intent intent = new Intent(this, ReactDemo.class);
            startActivity(intent);
        } else if (id == R.id.nav_userprofile) {
            Intent intent = new Intent(this, UserProfile.class);
            startActivity(intent);
        } else if (id == R.id.nav_signup) {
            Intent intent = new Intent(this, Signup.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_skills) {
            Intent intent = new Intent(this, UserSkills.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_calendar) {
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new MyReactPackage());
    }
}
