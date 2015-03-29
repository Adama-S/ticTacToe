package com.example.ticTacToe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

/**
 * Created by asus on 27/03/2015.
 */
public class Calculator extends Activity {

    boolean isCheckedIA, isCheckedPlayer, isCross, isPlayer1;
    private boolean myTurn = false;
    private char tab[][] = new char[3][3];



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);


        Bundle values = getIntent().getExtras();
        if(values != null)
        {
            isCheckedIA = values.getBoolean("isCheckedIA");
            isCheckedPlayer = values.getBoolean("isCheckedPlayer");
            isCross = values.getBoolean("isCross");
            isPlayer1 = values.getBoolean("isPlayer1");
            if(isCheckedPlayer){
                setupOnClickListeners();
            }
            else {
                Toast.makeText(Calculator.this,"Sorry, nothing to show for now!", Toast.LENGTH_LONG).show();
            }




        }


        }

    private void setupOnClickListeners() {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++) {
            if (T.getChildAt(y) instanceof TableRow) {
                TableRow R = (TableRow) T.getChildAt(y);
                for (int x = 0; x < R.getChildCount(); x++) {
                    View V = R.getChildAt(x); // In our case this will be each button on the grid
                    V.setOnClickListener(new PlayOnClick(x, y));
                }
            }
        }
    }

    private class PlayOnClick implements View.OnClickListener {

        private int x = 0;
        private int y = 0;

        public PlayOnClick(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void onClick(View view) {
            Bundle values = getIntent().getExtras();
            if(values != null)
            {
                isCross = values.getBoolean("isCross");
                isPlayer1 = values.getBoolean("isPlayer1");


                if (view instanceof Button) {
                    Button B = (Button) view;

                    if(!isPlayer1){

                        if(isCross){
                            tab[x][y] = myTurn ? 'X' : 'O';
                            B.setText(myTurn ? "X" : "O");
                        }else
                        {
                            tab[x][y] = myTurn ? 'O' : 'X';
                            B.setText(myTurn ? "O" : "X");
                        }

                    }else{

                        if(isCross){
                            tab[x][y] = myTurn ? 'O' : 'X';
                            B.setText(myTurn ? "O" : "X");
                        }else
                        {
                            tab[x][y] = myTurn ? 'X' : 'O';
                            B.setText(myTurn ? "X" : "O");
                        }
                    }

                    B.setEnabled(false);
                    myTurn = !myTurn;



                    if (checkWinner(tab, 3, 'X')) {
                        Toast.makeText(Calculator.this,"X wins!", Toast.LENGTH_LONG).show();
                        disableButtons();
                    } else if (checkWinner(tab, 3, 'O')) {
                        Toast.makeText(Calculator.this,"O wins!", Toast.LENGTH_LONG).show();
                        disableButtons();
                    }


            }


                // check if anyone has won
//                if (checkWin()) {
//                    disableButtons();
//                }
            }
        }
    }

    private boolean checkWinner(char[][] board, int size, char player) {
        // check each column
        for (int x = 0; x < size; x++) {
            int total = 0;
            for (int y = 0; y < size; y++) {
                if (board[x][y] == player) {
                    total++;
                }
            }
            if (total >= size) {
                return true; // they win
            }
        }

        // check each row
        for (int y = 0; y < size; y++) {
            int total = 0;
            for (int x = 0; x < size; x++) {
                if (board[x][y] == player) {
                    total++;
                }
            }
            if (total >= size) {
                return true; // they win
            }
        }

        // forward diag
        int total = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x == y && board[x][y] == player) {
                    total++;
                }
            }
        }
        if (total >= size) {
            return true; // they win
        }

        // backward diag
        total = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x + y == size - 1 && board[x][y] == player) {
                    total++;
                }
            }
        }
        if (total >= size) {
            return true; // they win
        }

        return false; // nobody won
    }


    private void disableButtons() {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++) {
            if (T.getChildAt(y) instanceof TableRow) {
                TableRow R = (TableRow) T.getChildAt(y);
                for (int x = 0; x < R.getChildCount(); x++) {
                    if (R.getChildAt(x) instanceof Button) {
                        Button B = (Button) R.getChildAt(x);
                        B.setEnabled(false);
                    }
                }
            }
        }
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
//        Toast.makeText(Calculator.this,"onPause()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();
//        Toast.makeText(Calculator.this,"onStop()", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(Calculator.this,"onDestroy()", Toast.LENGTH_LONG).show();

    }


}
