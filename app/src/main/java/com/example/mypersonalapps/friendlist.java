package com.example.mypersonalapps;

/**
 * Nama : Dzaki Fakhruddin
 * NIM : 10116156
 * Kelas : AKB 4
 * Waktu Pengerjaan : 15 Agustus 2019
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class friendlist extends Fragment {

    private RecyclerView recyclerView;
    private Button buttonAdd;
    private MainRecyclerAdapter adapter;
    private List<FriendModel> friendModelList = new ArrayList<>();
    private AppCompatDialog dialog;
    private MainPresenter presenter;


    /*public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_friendlist, container, false);
        return view;*/

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        presenter = new ImplementasiPresenter((FriendView) getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MainRecyclerAdapter(friendModelList);
        adapter.setOnCallbackListener(new MainRecyclerAdapter.OnCallbackListener() {
            @Override
            public void onClick(FriendModel friend) {
                showDialogUpdate(friend);
            }
        });
        recyclerView.setAdapter(adapter);

        buttonAdd.findViewById(R.id.btn_main_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogInput();
            }
        });
        presenter.load();
    }

    private void onLoad(List<FriendModel> friends){
        friendModelList.clear();
        friendModelList.addAll(friends);
        adapter.notifyDataSetChanged();
    }

    private void onSave(){

    }

    private void onDelete(){

    }

    private void onUpdate(){

    }

    public void showDialogInput(){
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("Tambah Data Teman");

        final EditText editnama = dialog.findViewById(R.id.edit_nama);
        final EditText editkelas = dialog.findViewById(R.id.edit_kelas);
        final EditText editnohp = dialog.findViewById(R.id.edit_nohp);
        final EditText editemail = dialog.findViewById(R.id.edit_email);
        final EditText editsosmed = dialog.findViewById(R.id.edit_sosmed);

        Button buttonsave = dialog.findViewById(R.id.btn_simpan);
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FriendModel friend = new FriendModel();
                friend.setNama(editnama.getText().toString());
                friend.setKelas(editkelas.getText().toString());
                friend.setNohp(editnohp.getText().toString());
                friend.setEmail(editemail.getText().toString());
                friend.setSosmed((editsosmed.getText().toString()));
                presenter.save(friend);
                dialog.dismiss();
            }
        });
        Button buttoncancel = dialog.findViewById(R.id.btn_cancel);
        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        if(!dialog.isShowing()){
            dialog.show();
        }
    }

    public void showDialogUpdate(final FriendModel friend){
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("Update Data Teman");

        final EditText editnama = dialog.findViewById(R.id.edit_nama);
        final EditText editkelas = dialog.findViewById(R.id.edit_kelas);
        final EditText editnohp = dialog.findViewById(R.id.edit_nohp);
        final EditText editemail = dialog.findViewById(R.id.edit_email);
        final EditText editsosmed = dialog.findViewById(R.id.edit_sosmed);

        editnama.setText(friend.getNama());
        editkelas.setText(friend.getKelas());
        editnohp.setText(friend.getNohp());
        editemail.setText(friend.getEmail());
        editsosmed.setText(friend.getSosmed());

        Button buttonUpdate = dialog.findViewById(R.id.btn_simpan);
        buttonUpdate.setText("Update");
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friend.setNama(editnama.getText().toString());
                friend.setKelas(editkelas.getText().toString());
                friend.setNohp(editnohp.getText().toString());
                friend.setEmail(editemail.getText().toString());
                friend.setSosmed((editsosmed.getText().toString()));
                presenter.update(friend);
                dialog.dismiss();
            }
        });
        Button buttondelete = dialog.findViewById(R.id.btn_cancel);
        buttondelete.setText("Delete");
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.delete(friend);
                dialog.dismiss();
            }
        });
        if(!dialog.isShowing()){
            dialog.show();
        }
    }

}