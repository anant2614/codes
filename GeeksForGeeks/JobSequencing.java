package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencing {

	class Job {
		int deadline;
		int profit;

		public Job(int deadline, int profit) {
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	public static void main(String ar[]) {
		int max_deadline = 3;
		List<Job> jobs = new ArrayList<>();
		Job a = new JobSequencing().new Job(2, 100);
		jobs.add(a);
		Job b = new JobSequencing().new Job(1, 19);
		jobs.add(b);
		Job c = new JobSequencing().new Job(2, 27);
		jobs.add(c);
		Job d = new JobSequencing().new Job(1, 25);
		jobs.add(d);
		Job e = new JobSequencing().new Job(3, 15);
		jobs.add(e);
		Collections.sort(jobs, (j1, j2) -> {
			return j2.profit - j1.profit;
		});
		Job[] seq = new Job[max_deadline];
		findSequence(jobs, seq);
		System.out.println(seq);
	}

	private static void findSequence(List<Job> jobs, Job[] seq) {
		int[] slots = new int[seq.length];
		for (int i = 0; i < jobs.size(); i++) {
			for (int j = jobs.get(i).deadline - 1; j >= 0; j--) {
				if (slots[j] == 0) {
					slots[j] = 1;
					seq[j] = jobs.get(i);
					break;
				}
			}
		}
	}
}
