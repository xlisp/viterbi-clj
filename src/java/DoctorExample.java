package com.hankcs.algorithm;

import static com.hankcs.algorithm.DoctorExample.Status.*;
import static com.hankcs.algorithm.DoctorExample.Feel.*;

public class DoctorExample
{
    public enum Status
    {
        Healthy,
        Fever,
    }
    public enum Feel
    {
        normal,
        cold,
        dizzy,
    }
    public static int[] states = new int[]{Healthy.ordinal(), Fever.ordinal()};
    public static int[] observations = new int[]{normal.ordinal(), cold.ordinal(), dizzy.ordinal()};
    public static double[] start_probability = new double[]{0.6, 0.4};
    public static double[][] transititon_probability = new double[][]{
            {0.7, 0.3},
            {0.4, 0.6},
    };
    public static double[][] emission_probability = new double[][]{
            {0.5, 0.4, 0.1},
            {0.1, 0.3, 0.6},
    };
    public static void main(String[] args)
    {
        int[] result = Viterbi.compute(observations, states, start_probability, transititon_probability, emission_probability);
        for (int r : result)
        {
            System.out.print(Status.values()[r] + " ");
        }
        System.out.println();
    }    
}
