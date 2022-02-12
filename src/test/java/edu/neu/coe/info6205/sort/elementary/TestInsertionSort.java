package edu.neu.coe.info6205.sort.elementary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

import org.junit.Test;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.ConfigTest;
import edu.neu.coe.info6205.util.Timer;

public class TestInsertionSort {
	public Integer getRandomNumber(int max) {
		Random rand = new Random();
		Integer n = rand.nextInt(max);
		return n += 1;
	}

	public Integer[] getRandomArray(int size) {
		Integer[] xs = new Integer[size];
		int i = 0;
		while (i < size) {
			Integer randVal = getRandomNumber(size);
			xs[i] = randVal;
			i++;
		}
		return xs;
	}

	public Integer[] getPartiallySortedArray(int size) {
		Integer[] xs = new Integer[size];
		int i = 0;
		while (i < size / 2) {
			xs[i] = i;
			i++;
		}
		while (i < size) {
			Integer randVal = getRandomNumber(size);
			xs[i] = randVal;
			i++;
		}
		return xs;
	}

	public Integer[] getReverseSortedArray(int size) {
		Integer[] xs = new Integer[size];
		int i = size - 1;
		while (i >= 0) {
			xs[i] = i;
			i--;
		}
		return xs;
	}

	public Integer[] getSortedArray(int size) {
		Integer[] xs = new Integer[size];
		int i = 0;
		while (i < size) {
			xs[i] = i;
			i++;
		}
		return xs;
	}

	@Test
	public void sortRandomOrdered() throws Exception {
		final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
		int n = 100;
		Helper<Integer> helper = HelperFactory.create("InsertionSort", n, config);
		helper.init(n);
		double totalMeanTime = 0;
		for (int i = 1; i < SIZE_DOUBLING_RANGE; i++) {
			Integer[] xs = getRandomArray(MIN_SIZE * i);
			SortWithHelper<Integer> sortRandomOrdered = new InsertionSort<Integer>(helper);
			Benchmark_Timer<Boolean> timer = new Benchmark_Timer<>("Randomly Sorted Elements of size" + xs.length,
					b -> {
						sortRandomOrdered.sort(xs, 0, xs.length - 1);
					});
			double x = timer.run(true, NET_ITERATIONS);
			System.out.println("****START****");
			System.out.println("Randomly Generated Array");
			System.out.println("Array Size: " + xs.length);
			System.out.println("Time taken to sort: " + x);
			System.out.println("*****END*****");
			totalMeanTime += x;
		}
		System.out.println(">>>> Mean Randomly sorting time ->" + totalMeanTime / SIZE_DOUBLING_RANGE);
		assertEquals(1, totalMeanTime / SIZE_DOUBLING_RANGE, 1);
	}

	@Test
	public void sortPartiallyOrdered() throws Exception {
		final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
		int n = 100;
		Helper<Integer> helper = HelperFactory.create("InsertionSort", n, config);
		helper.init(n);
		double totalMeanTime = 0;
		for (int i = 1; i < SIZE_DOUBLING_RANGE; i++) {
			Integer[] xs = getPartiallySortedArray(MIN_SIZE * i);
			SortWithHelper<Integer> sortRandomOrdered = new InsertionSort<Integer>(helper);
			Benchmark_Timer<Boolean> timer = new Benchmark_Timer<>("Partially Sorted Elements of size" + xs.length,
					b -> {
						sortRandomOrdered.sort(xs, 0, xs.length - 1);
					});
			double x = timer.run(true, NET_ITERATIONS);
			System.out.println("****START****");
			System.out.println("Partially Sorted Generated Array");
			System.out.println("Array Size: " + xs.length);
			System.out.println("Time taken to sort: " + x);
			System.out.println("*****END*****");
			totalMeanTime += x;
		}
		System.out.println(">>>> Mean Partially sorting time ->" + totalMeanTime / SIZE_DOUBLING_RANGE);
		assertEquals(1, totalMeanTime / SIZE_DOUBLING_RANGE, 1);
	}

	@Test
	public void sortReverseOrdered() throws Exception {
		final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
		int n = 100;
		Helper<Integer> helper = HelperFactory.create("InsertionSort", n, config);
		helper.init(n);
		double totalMeanTime = 0;
		for (int i = 1; i < SIZE_DOUBLING_RANGE; i++) {
			Integer[] xs = getReverseSortedArray(MIN_SIZE * i);
			SortWithHelper<Integer> sortRandomOrdered = new InsertionSort<Integer>(helper);
			Benchmark_Timer<Boolean> timer = new Benchmark_Timer<>("Reverse Sorted Elements of size" + xs.length, b -> {
				sortRandomOrdered.sort(xs, 0, xs.length - 1);
			});
			double x = timer.run(true, NET_ITERATIONS);
			System.out.println("****START****");
			System.out.println("Reverse Sorted Generated Array");
			System.out.println("Array Size: " + xs.length);
			System.out.println("Time taken to sort: " + x);
			System.out.println("*****END*****");
			totalMeanTime += x;
		}
		System.out.println(">>>> Mean Reverse sorting time ->" + totalMeanTime / SIZE_DOUBLING_RANGE);
		assertEquals(1, totalMeanTime / SIZE_DOUBLING_RANGE, 1);
	}

	@Test
	public void sortOrdered() throws Exception {
		final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
		int n = 100;
		Helper<Integer> helper = HelperFactory.create("InsertionSort", n, config);
		helper.init(n);
		double totalMeanTime = 0;
		for (int i = 1; i < SIZE_DOUBLING_RANGE; i++) {
			Integer[] xs = getSortedArray(MIN_SIZE * i);
			SortWithHelper<Integer> sortRandomOrdered = new InsertionSort<Integer>(helper);
			Benchmark_Timer<Boolean> timer = new Benchmark_Timer<>("Sorted Elements of size" + xs.length, b -> {
				sortRandomOrdered.sort(xs, 0, xs.length - 1);
			});
			double x = timer.run(true, NET_ITERATIONS);
			System.out.println("****START****");
			System.out.println("Sorted Generated Array");
			System.out.println("Array Size: " + xs.length);
			System.out.println("Time taken to sort: " + x);
			System.out.println("*****END*****");
			totalMeanTime += x;
		}
		System.out.println(">>>> Mean Sorted sorting time ->" + totalMeanTime / SIZE_DOUBLING_RANGE);
		assertEquals(1, totalMeanTime / SIZE_DOUBLING_RANGE, 1);
	}

	private final int NET_ITERATIONS = 100;
	private final int MIN_SIZE = 400;
	private final int SIZE_DOUBLING_RANGE = 10;
}