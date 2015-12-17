import java.util.Queue;
import java.util.LinkedList;

class RoundRobin {

	class Process {

		int arriveTime, remainTime;

		public Process(int arriveTime, int remainTime) {
			this.arriveTime = arriveTime;
			this.remainTime = remainTime;
		}
	}

	public double avgWaitingTime (int[] arriveTime, int[] executeTime, int q) {
		Queue<Process> queue = new LinkedList<Process>();
		int currTime = 0;
		int waitTime = 0;
		int nextProcId = 0;

		while (!queue.isEmpty() || nextProcId < arriveTime.length) {
			if (queue.isEmpty()) {
				Process p = new Process(arriveTime[nextProcId], executeTime[nextProcId]);

				currTime = p.arriveTime;
				queue.offer(p);
				nextProcId++;
			} else {
				Process curr = queue.poll();
				int execTime = (curr.remainTime < q) ? curr.remainTime : q;

				waitTime += currTime - curr.arriveTime;
				currTime += execTime;
				while (nextProcId < arriveTime.length && arriveTime[nextProcId] <= currTime) {
					Process p = new Process(arriveTime[nextProcId], executeTime[nextProcId]);

					queue.offer(p);
					nextProcId++;
				}
				if (curr.remainTime > q) {
					curr.arriveTime = currTime;
					curr.remainTime -= q;
					queue.offer(curr);
				}
			}
		}

		return (double)waitTime / arriveTime.length;
	}

	public static void main(String[] args) {
		if (args.length < 4) {
			System.out.println("Not enough parameters");
		} else {
			int q = Integer.parseInt(args[0]);
			int n = Integer.parseInt(args[1]);
			if (args.length - 2 < 2 * n) {
				System.out.println("Not enough elements");
			} else {
				RoundRobin rr = new RoundRobin();
				int[] arriveTime = new int[n];
				int[] executeTime = new int[n];

				for (int i = 0; i < n; i++) {
					arriveTime[i] = Integer.parseInt(args[i+2]);
					executeTime[i] = Integer.parseInt(args[i+n+2]);
				}

				System.out.println("Average waiting time: " + rr.avgWaitingTime(arriveTime, executeTime, q));
			}
		}
	}
}
