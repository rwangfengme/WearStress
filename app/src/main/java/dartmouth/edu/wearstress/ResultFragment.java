package dartmouth.edu.wearstress;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by _ReacTor on 16/2/2.
 */
public class ResultFragment extends Fragment{
    private final int NUMBER_OF_VALUES_IN_CHART = 6;
    private final int[] suggestionWords =
            {R.string.words_stress_1, R.string.words_stress_3, R.string.words_stress_5,
                    R.string.words_stress_7, R.string.words_stress_9, R.string.words_stress_11,
                    R.string.words_stress_13, R.string.words_stress_15};

    public ArrayList<String> getTimes() {
        return times;
    }

    public ArrayList<String> getStresses() {
        return stresses;
    }

    private ArrayList<String> times;
    private ArrayList<String> stresses;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        times = new ArrayList<>();
        stresses = new ArrayList<>();

        View view = inflater.inflate(R.layout.frag_result, container, false);

        TextView tv = (TextView) view.findViewById(R.id.suggestion);
        int stressDegree = ((MainActivity)getActivity()).stressDegree;
        if (stressDegree == 0){
            tv.setText(getString(R.string.hint));
        }
        else {
            int words = suggestionWords[(stressDegree-1)/2];
            tv.setText(getString(words));
        }

        try {
            FileInputStream in = getActivity().openFileInput("stress.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] timeAndStress = line.split(",");
                times.add(timeAndStress[0]);
                stresses.add(timeAndStress[1]);
            }
        } catch (FileNotFoundException e) {
            FileOutputStream outputStream = null;
            try {
                outputStream = getActivity().openFileOutput("stress.txt", Context.MODE_PRIVATE);
                outputStream.write("".getBytes());
                outputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        LineChart chart = (LineChart) view.findViewById(R.id.chart);
        ArrayList<Entry> stressVals = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VALUES_IN_CHART - times.size(); i++) {
            stressVals.add(new Entry(0f, i));
        }
        for (int i = Math.max(times.size() - NUMBER_OF_VALUES_IN_CHART, 0); i < times.size() ; i++) {
            stressVals.add(new Entry(Float.parseFloat(stresses.get(i)), i - (times.size() - NUMBER_OF_VALUES_IN_CHART)));
        }

        LineDataSet dataSet = new LineDataSet(stressVals, "");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("1");
        labels.add("2");
        labels.add("3");
        labels.add("4");
        labels.add("5");
        labels.add("6");

        LineData data = new LineData(labels, dataSet);
        dataSet.setDrawCubic(true);
        dataSet.setDrawFilled(true);
        dataSet.setFillAlpha(200);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(10);
        dataSet.setValueFormatter(new MyValueFormatter());


        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisRight().setEnabled(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getXAxis().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setDrawGridBackground(false);

        //dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
        chart.setDescription("");
        chart.invalidate(); // refresh

        return view;
    }
}

class MyValueFormatter implements ValueFormatter {

    private DecimalFormat mFormat;

    public MyValueFormatter() {
        mFormat = new DecimalFormat("0"); // use one decimal
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        // write your logic here
        return mFormat.format(value); // e.g. append a dollar-sign
    }
}