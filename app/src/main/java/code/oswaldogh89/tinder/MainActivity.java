package code.oswaldogh89.tinder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.daprlabs.cardstack.SwipeDeck;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SwipeDeck cardStack;
    private Context context = this;

    private CardAdapter adapter;
    private ArrayList<String> testData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        testData = new ArrayList<>();
        testData.add("http://www.buenamusica.com/media/fotos/cantantes/biografia/romeo-santos.jpg");
        testData.add("http://circulart.org/circulart/admin/imagen.php?table=archivos_obras_musica&field=archivo&id=39148");
        testData.add("http://www.buenamusica.com/media/fotos/cantantes/biografia/ariana-grande.jpg");
        testData.add("http://1.bp.blogspot.com/-tEgF8rVPvII/VhxibyihFzI/AAAAAAAAJcc/jjZA-FhksDA/s1600/regil.jpg");
        testData.add("http://i2.wp.com/www.autoeditados.org/wp-content/uploads/2013/07/Abd%C3%B3n-Alcaraz-Perfil.png?resize=450%2C312");

        adapter = new CardAdapter(testData, this);
        cardStack.setAdapter(adapter);

        cardStack.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {
            }

            @Override
            public void cardSwipedRight(int position) {
            }

            @Override
            public void cardsDepleted() {
            }

            @Override
            public void cardActionDown() {
            }

            @Override
            public void cardActionUp() {
            }

        });
        cardStack.setLeftImage(R.id.left_image);
        cardStack.setRightImage(R.id.right_image);

        ImageButton btn = (ImageButton) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStack.swipeTopCardLeft(180);
            }
        });
        ImageButton btn2 = (ImageButton) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStack.swipeTopCardRight(180);
            }
        });

        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testData.add("a sample string.");
                adapter.notifyDataSetChanged();
            }
        });
    }


}
