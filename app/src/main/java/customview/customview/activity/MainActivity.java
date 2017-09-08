package customview.customview.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import customview.customview.R;

public class MainActivity extends BaseActivity {

    public static final PracticeDetail[] names = new PracticeDetail[]{
            new PracticeDetail<>("CustomView_1",CustomViewActivity1.class),
            new PracticeDetail<>("CustomView_2",CustomViewActivity2.class),
            new PracticeDetail<>("CustomView_3",CustomViewActivity3.class),
    };

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected int setContentViewByResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerView.Adapter<MainHolder>() {
            @Override
            public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                final MainHolder holder = new MainHolder(view);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,names[holder.getLayoutPosition()].getActivityClass());
                        startActivity(intent);
                    }
                });
                return holder;
            }

            @Override
            public void onBindViewHolder(MainHolder holder, int position) {
                holder.bindData(position);
            }

            @Override
            public int getItemCount() {
                return names.length;
            }
        });
    }

    private class MainHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MainHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView;
        }

        public void bindData(int position) {
            tv.setText(names[position].getTitle());
        }
    }

    private static class PracticeDetail<T extends BaseActivity> {
        private String title;
        private Class<T> activityClass;

        public PracticeDetail(String title, Class<T> activityClass) {
            this.title = title;
            this.activityClass = activityClass;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Class<T> getActivityClass() {
            return activityClass;
        }

        public void setActivityClass(Class<T> activityClass) {
            this.activityClass = activityClass;
        }
    }
}
