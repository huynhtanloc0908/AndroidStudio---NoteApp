        package com.example.noteapp;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageButton;
        import android.widget.TextView;
        import android.widget.Toast;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
        import java.util.ArrayList;
        import java.util.List;

        public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

            private List<Note> noteList;

            public NoteAdapter() {
                this.noteList = new ArrayList<>();
            }

            @NonNull
            @Override
            public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_note, parent, false);
                return new NoteViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
                Note note = noteList.get(position);

                holder.tvTitle.setText(note.getTitle());
                holder.tvContent.setText(note.getContent());
                holder.tvDate.setText(note.getDate());

                // Click vào card
                holder.itemView.setOnClickListener(v -> {
                    Toast.makeText(v.getContext(), "Clicked: " + note.getTitle(), Toast.LENGTH_SHORT).show();
                });

                // Click nút Edit
                holder.btnEdit.setOnClickListener(v -> {
                    Toast.makeText(v.getContext(), "Edit: " + note.getTitle(), Toast.LENGTH_SHORT).show();
                });

                // Click nút Delete
                holder.btnDelete.setOnClickListener(v -> {
                    noteList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, noteList.size());
                    Toast.makeText(v.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public int getItemCount() {
                return noteList.size();
            }

            // Thêm dữ liệu
            public void setNotes(List<Note> notes) {
                this.noteList = notes;
                notifyDataSetChanged();
            }

            public void addNote(Note note) {
                noteList.add(0, note);
                notifyItemInserted(0);
            }

            static class NoteViewHolder extends RecyclerView.ViewHolder {
                TextView tvTitle, tvContent, tvDate;
                ImageButton btnEdit, btnDelete;

                public NoteViewHolder(@NonNull View itemView) {
                    super(itemView);
                    tvTitle = itemView.findViewById(R.id.tvTitle);
                    tvContent = itemView.findViewById(R.id.tvContent);
                    tvDate = itemView.findViewById(R.id.tvDate);
                    btnEdit = itemView.findViewById(R.id.btnEdit);
                    btnDelete = itemView.findViewById(R.id.btnDelete);
                }
            }
        }