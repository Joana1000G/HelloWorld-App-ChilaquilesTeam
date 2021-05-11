package com.example.hellochilaquilesteam;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.example.hellochilaquilesteam.models.Comment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     CommentListFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class CommentListFragment extends BottomSheetDialogFragment {

    //Variale de clase constante
    private static final String KEY_BOOK_ID = "bookId";

    // TODO: Customize parameters
    public static CommentListFragment newInstance(String bookId) {
        final CommentListFragment fragment = new CommentListFragment();

        //Diccionario o mapa = ES Key - Value (int, String, Boolean, Char)
        //Permiten las asociaciones
        final Bundle args = new Bundle();

        args.putString(KEY_BOOK_ID, bookId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) view;

        Bundle diccionarioValores = getArguments();

        //TODO falta utilizar el valor de la variable
        //Se van a consultar los datos del libro
        String bookId = diccionarioValores.getString(KEY_BOOK_ID);

        ArrayList<Comment> comments = new ArrayList<>();
        comments.add(new Comment("Muy buen libro, recomendadisímo"));
        comments.add(new Comment("Me gustó mucho la manera en la que te hace reflexionar"));
        comments.add(new Comment("Me gusta la perspectiva de el libro"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        CommentAdapter adapter = new CommentAdapter(comments);
        recyclerView.setAdapter(adapter);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        final TextView text;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.item_comment, parent, false));
            text = itemView.findViewById(R.id.text);
        }
    }

    private class CommentAdapter extends RecyclerView.Adapter<ViewHolder> {

        private ArrayList<Comment> list;

        CommentAdapter(ArrayList<Comment> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Comment comment = list.get(position);
            holder.text.setText(comment.getComment());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

    }

}