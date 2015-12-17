import java.util.PriorityQueue;
import java.util.Comparator;

class SJF {

	class Process implements Comparator<Process> {

		int arriveTime, remainTime;

		public Process() {}

		public Process(int arriveTime, int remainTime) {
			this.arriveTime = arriveTime;
			this.remainTime = remainTime;
		}

		public int compare(Process p1, Process p2) {
			if (p1.remainTime == p2.remainTime)
				return p1.arriveTime - p2.arriveTime;
			return p1.remainTime - p2.remainTime;
		}
	}

	public double avgWaitingTime (int[] arriveTime, int[] executeTime) {
		PriorityQueue<Process> queue = new PriorityQueue<Process>(arriveTime.length, new Process());
		int currTime = 0;
		int waitTime = 0;
		int nextProcId = 0;

		while (!queue.isEmpty() || nextProcId < arriveTime.length) {
			if (queue.isEmpty()) {
				currTime = arriveTime[nextProcId];
				while (nextProcId < arriveTime.length && arriveTime[nextProcId] == currTime) {
					queue.offer(new Process(arriveTime[nextProcId], executeTime[nextProcId]));
					nextProcId++;
				}
			} else {
				Process curr = queue.poll();
				int execTime = (nextProcId < arriveTime.length && arriveTime[nextProcId] - currTime < curr.remainTime) ?
					arriveTime[nextProcId] - currTime : curr.remainTime;

				waitTime += currTime - curr.arriveTime;
				currTime += execTime;
				while (nextProcId < arriveTime.length && arriveTime[nextProcId] == currTime) {
					queue.offer(new Process(arriveTime[nextProcId], executeTime[nextProcId]));
					nextProcId++;
				}
				if (curr.remainTime > execTime) {
					curr.arriveTime = currTime;
					curr.remainTime -= execTime;
					queue.offer(curr);
				}
			}
		}

		return (double)waitTime / arriveTime.length;
	}

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Not enough parameters");
		} else {
			int n = Integer.parseInt(args[0]);
			if (args.length - 1 < 2 * n) {
				System.out.println("Not enough elements");
			} else {
				SJF sjf = new SJF();
				int[] arriveTime = new int[n];
				int[] executeTime = new int[n];

				for (int i = 0; i < n; i++) {
					arriveTime[i] = Integer.parseInt(args[i+1]);
					executeTime[i] = Integer.parseInt(args[i+n+1]);
				}

				System.out.println("Average waiting time: " + sjf.avgWaitingTime(arriveTime, executeTime));
			}
		}
	}
}
