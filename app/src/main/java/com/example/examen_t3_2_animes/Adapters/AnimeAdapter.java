package com.example.examen_t3_2_animes.Adapters;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_t3_2_animes.Clases.Anime;
import com.example.examen_t3_2_animes.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.PalabraViewHolder>{

    List<Anime> animes;

    public AnimeAdapter(List<Anime> animes) {
        this.animes = animes;
    }

    @Override
    public PalabraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new PalabraViewHolder(view);
    }

    @Override
    public void onBindViewHolder( AnimeAdapter.PalabraViewHolder holder, int position) {
        View view= holder.itemView;
        Anime anime = animes.get(position);

        ImageView idImage = holder.itemView.findViewById(R.id.idImagen);
        ImageView idFavorito = holder.itemView.findViewById(R.id.idImagen2);

        TextView tvNombre =holder.itemView.findViewById(R.id.tvNombre);
        TextView tvDescripcion = holder.itemView.findViewById(R.id.tvDescripcion);

        tvNombre.setText(anime.getNombre());
        tvDescripcion.setText(anime.getDescripcion());



        idFavorito.setImageResource(R.drawable.estrellablanca);
        Picasso.get().load(anime.getFoto()).into(idImage);
        Picasso.get()
                .load(anime.getFoto())
                .resize(50, 50)
                .centerCrop()
                .into(idImage);


        idFavorito.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                if(event.getAction() == MotionEvent.ACTION_DOWN)
//                {
//                    idFavorito.setImageResource(R.drawable.estrellablanca);
//                }
                 if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    idFavorito.setImageResource(R.drawable.estrellanegra);

                }
                 else if(event.getAction() == MotionEvent.ACTION_UP)
                       {
                    idFavorito.setImageResource(R.drawable.estrellablanca);
               }
              return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public class PalabraViewHolder extends RecyclerView.ViewHolder {
        public PalabraViewHolder( View itemView) {
            super(itemView);
        }
    }


}
