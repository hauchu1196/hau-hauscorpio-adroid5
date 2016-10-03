package com.example.hau.session9turn4;

/**
 * Created by Hau on 02/10/2016.
 */
public class NewItem {
    private String title;
    private int imageResId;
    private String time;

    public NewItem(String title, int imageResId, String time) {
        this.title = title;
        this.imageResId = imageResId;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public static final NewItem[] ARRAY = new NewItem[] {
            new NewItem(
                    "He may act like he wants a secretary but most of the time they’re looking for…",
                    R.drawable.item1,
                    "10min"
            ),
            new NewItem(
                    "Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face",
                    R.drawable.item2,
                    "13min"
            ),
            new NewItem(
                    "Go home, take a paper bag and cut some eyeholes out of it. Put it over your head",
                    R.drawable.item3,
                    "16min"
                    ),
            new NewItem(
                    "Get out of here and move forward. This never happened. It will shock you how much",
                    R.drawable.item4,
                    "19min"
            ),
            new NewItem(
                    "That poor girl. She doesn’t know that loving you is the worst way to get you",
                    R.drawable.item5,
                    "21min"
            ),
    };
}
