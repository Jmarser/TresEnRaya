package com.jmarser.tresenraya.utils;

import com.jmarser.tresenraya.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Clase que contiene métodos para realizar la navegación entre fragments
 * */
public class NavigationFragment {

    /* Método con el que reemplazamos un fragment por otro */
    public static void replaceFragment(FragmentManager fm, Fragment fragment, String fragmentTag){
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, 0, 0, android.R.anim.fade_out);
        ft.replace(R.id.frame, fragment, fragmentTag);
        ft.addToBackStack(fragmentTag);
        ft.commitAllowingStateLoss();
    }

    /**
     * Método con el que se realiza la navegación entre fragments, reemplazando uno por otro, éste método nos permite
     * reutilizarlo en diferentes activitys que lo llamen ya que el contenedor del fragment se pasa por
     * parámetro.
     * @param fm FragmentManager que gestiona la acción
     * @param fragment Fragment que queremos mostrar.
     * @param fragmentTag nombre del fragmento para identificarlo.
     * @param idFrame identificador del contenedor del fragment.
     * */
    public static void replaceFragmentBinding(FragmentManager fm, Fragment fragment, String fragmentTag, int idFrame){
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, 0, 0, android.R.anim.fade_out);
        ft.replace(idFrame, fragment, fragmentTag);
        ft.addToBackStack(fragmentTag);
        ft.commitAllowingStateLoss();
    }

    /* Método con el que agregamos un fragment a un frame */
    public static void addFragment(FragmentManager fm, Fragment fragment, String fragmentTag){
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, 0, 0, android.R.anim.fade_out);
        ft.add(R.id.frame, fragment, fragmentTag);
        ft.addToBackStack(fragmentTag);
        ft.commitAllowingStateLoss();
    }

    /**
     * Método con el que se realiza la navegación entre fragments, agrega un fragmento, éste método nos permite
     * reutilizarlo en diferentes activitys que lo llamen ya que el contenedor del fragment se pasa por
     * parámetro.
     * @param fm FragmentManager que gestiona la acción
     * @param fragment Fragment que queremos mostrar.
     * @param fragmentTag nombre del fragmento para identificarlo.
     * @param idFrame identificador del contenedor del fragment.
     * */
    public static void addFragmentBindig(FragmentManager fm, Fragment fragment, String fragmentTag, int idFrame){
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, 0, 0, android.R.anim.fade_out);
        ft.add(idFrame, fragment, fragmentTag);
        ft.addToBackStack(fragmentTag);
        ft.commitAllowingStateLoss();
    }
}
