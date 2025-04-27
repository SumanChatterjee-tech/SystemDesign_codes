package com.home.ConcertBookingSystem;

public class Seat {
	private final String id;
	private final int row;
	private final int col;
	private final SeatType seatType;
	private final double price;
	private SeatStatus status;

	public Seat(String id, int row, int col, SeatType seatType, double price, SeatStatus status) {
		super();
		this.id = id;
		this.row = row;
		this.col = col;
		this.seatType = seatType;
		this.price = price;
		this.status = status;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public double getPrice() {
		return price;
	}

	public synchronized void book() throws Exception {
		if (status == SeatStatus.AVAILABLE) {
			status = SeatStatus.BOOKED;
		} else {
			throw new Exception("Seat is already booked or reserved.");
		}
	}

	public synchronized void release() {
		if (status == SeatStatus.BOOKED) {
			status = SeatStatus.AVAILABLE;
		}
	}
}
