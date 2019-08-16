package com.example.mypersonalapps;
/**
 * Nama : Dzaki Fakhruddin
 * NIM : 10116156
 * Kelas : AKB 4
 * Waktu Pengerjaan : 16 Agustus 2019
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class profil extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profil, container, false);

        return view;
    }
}
