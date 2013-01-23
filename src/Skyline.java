public class Skyline {

	public static class EndOfTheCityException extends Exception {
		private static final long serialVersionUID = 357409559228218122L;

		public EndOfTheCityException(String msg) {
			super(msg);
		}
	}

	public static class Building {
		private int left;
		private int height;
		private int right;

		public Building(int left, int height, int right) {
			this.left = left;
			this.height = height;
			this.right = right;
		}

		public int getLeft() {
			return this.left;
		}

		public int getHeight() {
			return this.height;
		}

		public int getRight() {
			return this.right;
		}

	}

	private static enum Walls {
		LEFT {
			@Override
			Position move(Building[] city, Position startPos) {
				return new Position(startPos.buildingNo, Walls.ROOF, startPos.x);
			}

			@Override
			int getCoordinate(Building b) {
				return b.left;
			}
		},
		ROOF {
			@Override
			Position move(Building[] city, Position startPos) throws EndOfTheCityException {
				int height = city[startPos.buildingNo].height;
				int edge = city[startPos.buildingNo].right;
				for (int i = startPos.buildingNo + 1, n = city.length; city[i].left < edge && i < n; i++) {
					if (city[i].left > startPos.x && city[i].height > height)
						return new Position(i, Walls.LEFT, city[i].left);
				}
				return new Position(startPos.buildingNo, Walls.RIGHT, city[startPos.buildingNo].right);
			}

			@Override
			int getCoordinate(Building b) {
				return b.height;
			}
		},
		RIGHT {
			@Override
			Position move(Building[] city, Position startPos) throws EndOfTheCityException {
				throw new UnsupportedOperationException("Implementation not finished");
			}

			@Override
			int getCoordinate(Building b) {
				return b.right;
			}
		},
		GROUND {
			@Override
			Position move(Building[] city, Position startPos) throws EndOfTheCityException {
				for (int i = startPos.buildingNo + 1, n = city.length; i < n; i++) {
					if (city[i].left > startPos.x)
						return new Position(i, Walls.LEFT, city[i].left);
				}
				throw new EndOfTheCityException("This is the end of the city");
			}

			@Override
			int getCoordinate(Building b) {
				return 0;
			}
		};

		abstract Position move(Building[] city, Position startPos) throws EndOfTheCityException;

		abstract int getCoordinate(Building b);
	}

	private static class Position {
		int buildingNo;
		Walls wall;
		int x;

		Position(int b, Walls w, int x) {
			buildingNo = b;
			wall = w;
		}

		Position move(Building[] city) throws EndOfTheCityException {
			return this.wall.move(city, this);
		}

		int getCoordinate(Building[] city) {
			return this.wall.getCoordinate(city[buildingNo]);
		}
	}

	public static java.util.List<Integer> drawSkyline(Building[] city) {
		java.util.List<Integer> skyline = new java.util.ArrayList<>();
		skyline.add(city[0].left);
		Position p = new Position(0, Walls.LEFT, 0);
		try {
			while (true) {
				p = p.move(city);
				skyline.add(p.getCoordinate(city));
			}
		} catch (EndOfTheCityException e) {
			return skyline;
		}
	}

}