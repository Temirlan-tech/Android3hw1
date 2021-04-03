package com.example.andr3less1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.GnssAntennaInfo;
import android.os.Bundle;

import com.example.andr3less1.R;
import com.example.andr3less1.adapters.EmojiCardAdapter;

public class MainActivity extends AppCompatActivity implements EmojiCardAdapter.Listener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager  layoutManager;
    private EmojiCardAdapter emojiCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiCardAdapter = new EmojiCardAdapter(this);
        init();
        recyclerView.setAdapter(emojiCardAdapter);
    }

    private void init() {
        recyclerView = findViewById(R.id.rv_cards);
        layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void choose() {
        emojiCardAdapter.notifyDataSetChanged();
    }
}

//    паттерн (англ. design pattern) — повторимая архитектурная конструкция,
//        представляющая собой решение проблемы проектирования
//        в рамках некоторого часто возникающего контекста.

// MVC — это фундаментальный паттерн, который нашел применение во многих технологиях,
// дал развитие новым технологиям и каждый день облегчает жизнь разработчикам.
// В паттерне MVC слои между view и model соединяет controller
// в паттерне MVP presenter
// в папке domain хранить классы связанные с бизнес логикой
// в папке data хранить классы связанные с базами данными, сетью
// в папке ui хранить классы с отображением, активити, фрагменты, контроллеры

//1. Прочитать про hashCode() и equals()
//2. Вывести сообщение что игра завершена, когда все карточки удалены
//3. Добавить случайное распределение карточек +
//4. Исправить отображение одним списком. Сделать в два или три столбца +
//5. Добавить метод удаления карточек если было найдено совпадение +
//6. (Дополнительно) Добавить обратное переворачивание карточек если не было Match’a