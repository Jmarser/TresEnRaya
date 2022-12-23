package com.jmarser.tresenraya.addPlayers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.jmarser.tresenraya.R;
import com.jmarser.tresenraya.databinding.ActivityAddPlayersBinding;
import com.jmarser.tresenraya.di.component.AppComponent;
import com.jmarser.tresenraya.di.component.DaggerAppComponent;
import com.jmarser.tresenraya.di.module.AppModule;
import com.jmarser.tresenraya.selectPlayers.ui.SelectedPlayersFragment;

public class AddPlayersActivity extends AppCompatActivity {

    private ActivityAddPlayersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPlayersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initInjection();

        //Si no recivimos variable de estado, por defecto mostramos el fragment principal
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_fragment_right_to_left, R.anim.exit_fragment_left_to_right)
                    .replace(binding.selectedPlayersFrame.getId(), new SelectedPlayersFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
    }

    private void initInjection(){
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .build();

        appComponent.inject(this);
    }
}