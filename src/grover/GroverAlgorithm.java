package grover;

// https://github.com/dqdang/grover-algorithm

import java.util.*;

public class GroverAlgorithm {

    private int numQubits;
    private int value;
    private ArrayList<Double> vector;

    /* constructor */
    GroverAlgorithm(int numQubits, int value, ArrayList<Double> vector) {
        this.numQubits = numQubits;
        this.value = value;
        this.vector = vector;

    }

    /* ------------------------------------------------------------------------------
     * Method:	setVector()
     * Purpose:	Sets a vector to the object's vector.
     * Output:	The new vector.
     *
     * */

    public void setVector(ArrayList<Double> vector)
    {
        this.vector = vector;

    }

    /* ------------------------------------------------------------------------------
     * Method:	initializeBinary()
     * Purpose:	Prints the string of qubits given from the user in binary.
     * Output:	The vector in bra-ket notation.
     *
     * */
    public void initializeBinary()
    {
        Integer i = 0;
        double amplitude = 1 / Math.sqrt(Math.pow(2, numQubits));
        System.out.print(amplitude);
        System.out.print("(");
        for (i = 0; i < Math.pow(2, numQubits) - 1; i++)
        {
            System.out.print("|" + Integer.toBinaryString(i) + "> + ");
        }
        System.out.println("|" + Integer.toBinaryString(i) + ">)");

    }

    /* ------------------------------------------------------------------------------
     * Method:	initialize()
     * Purpose:	Prints the string of qubits given from the user in binary.
     * Output:	The vector in bra-ket notation.
     * Note:
     * 		1)  The decimal version. Provides readability.
     *
     * */
    public void initialize()
    {
        int i = 0;
        double amplitude = 1 / Math.sqrt(Math.pow(2, numQubits));
        System.out.print(amplitude);
        System.out.print("(");
        for (i = 0; i < Math.pow(2, numQubits) - 1; i++)
        {
            System.out.print("|" + i + "> + ");
        }
        System.out.println("|" + i + ">)");

    } /* initialize */

    /* ------------------------------------------------------------------------------
     * Method:	phaseInversion()
     * Purpose:	Executes the phase inversion step of Grover's algorithm.
     * Output:	The same vector, but with the value's sign switched.
     *
     * */
    public void phaseInversion()
    {
        double element = 0;
        element = vector.get(value);
        if (element < 0);
        else
        {
            element = -1 * element;
            vector.set(value, element);
        }

    } /* phaseInversion */

    /* ------------------------------------------------------------------------------
     * Method:	inversionMean()
     * Purpose:	Calculates the inversion about the mean.
     * Output:	Flips the amplitudes of the vector, so the probability of the state
     * 			collapsing onto it is greater.
     *
     * */
    public void inversionMean()
    {
        double average = 0;
        double element = 0;
        for (int i = 0; i < vector.size(); i++)
        {
            average += vector.get(i);
        }
        average = average / vector.size();

        for (int j = 0; j < vector.size(); j++)
        {
            element = vector.get(j);
            element = (average - element) + average;
            vector.set(j, element);
        }

    } /* inversionMean */

    /* ------------------------------------------------------------------------------
     * Method:	findProbability()
     * Purpose:	Calculates probability using the amplitudes squared
     * Output:	Probability of the state collapsing on the special value.
     *
     * */
    public double findProbability()
    {
        double probability = vector.get(value)/(Math.sqrt((Math.pow(2, numQubits))));
        probability = Math.pow(probability, 2);
        return probability;

    } /* findProbability */

    /* ------------------------------------------------------------------------------
     * Method:	createArray()
     * Purpose:	Create an array of 2^n slots.
     * Output:	New vector that will be passed into Grover's Algorithm.
     *
     * */
    public ArrayList<Double> createArray()
    {
        ArrayList<Double> newVector = new ArrayList<Double>();
        for (int i = 0; i < Math.pow(2, numQubits); i++)
        {
            newVector.add(1.0);
        }
        return newVector;

    } /* createArray */
}
