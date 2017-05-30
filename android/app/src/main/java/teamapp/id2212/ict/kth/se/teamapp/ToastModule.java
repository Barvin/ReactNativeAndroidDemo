package teamapp.id2212.ict.kth.se.teamapp;

import android.widget.Toast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import teamapp.id2212.ict.kth.se.teamapp.MainActivity;

import java.util.HashMap;
import java.util.Map;

import static teamapp.id2212.ict.kth.se.teamapp.MainActivity.*;

public class ToastModule extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public ToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    //accessed through React.NativeModules.ToastAndroid in JavaScript.
    @Override
    public String getName() {
        return "ToastAndroid";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void getCourses(){
        MainActivity.getCourses();
    }

    @ReactMethod
    public void setCourse(String name) {
        MainActivity.setCourse(name);
    }
}