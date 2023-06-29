class Solution {
	class Node {
		int row;
		int col;
		String key;

		Node(int row, int col, String key) {
			this.row = row;
			this.col = col;
			this.key = key;
		}

		public String toString(int row, int col, String key) {
			return row + "-" + col + "-" + key;
		}
	}

	public int shortestPathAllKeys(String[] grid) {
		int rows = grid.length;
		int cols = grid[0].length();

		int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
		Set<String> visited = new HashSet<>();

		int steps = 0;
		Queue<Node> queue = new LinkedList<>();

		int keyCount = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i].charAt(j) == '@') {
					queue.add(new Node(i, j, ""));
				} else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
					keyCount++;
				}
			}
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node temp = queue.poll();
				int r = temp.row;
				int c = temp.col;
				String key = temp.key;

				if (!visited.contains(temp.toString(r, c, key))) {
					visited.add(temp.toString(r, c, key));
				} else {
					continue;
				}

				if (key.length() == keyCount) {
					return steps;
				}

				for (int[] dir : dirs) {
					int nr = r + dir[0];
					int nc = c + dir[1];

					Node newNode = new Node(nr, nc, key);

					if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr].charAt(nc) == '#' || visited.contains(newNode.toString(nr, nc, key))) {
						continue;
					}

					char ch = grid[nr].charAt(nc);

					if (key.indexOf(ch) == -1 && ch >= 'a' && ch <= 'f') {
						queue.add(new Node(nr, nc, key + ch));
					} else if (ch >= 'A' && ch <= 'F' && key.indexOf(Character.toLowerCase(ch)) == -1) {
						continue;
					} else {
						queue.add(new Node(nr, nc, key));
					}
				}
			}

			steps += 1;
		}

		return -1;
	}
}