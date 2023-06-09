package com.example.finalproject.mapper;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.dto.BookingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookingMapper {
    public int memberSave(Booking booking);
    public int nonMemberSave(Booking booking);
    public List<Booking> findAll();
    public List<BookingDTO> findAllDTO();
    public int update(Booking booking);
    public int changeBookingState(Booking booking); //예매 상태 변경
    public int delete(int id);
    public Booking findByBookingId(int id);

    public BookingDTO findTicketByBookingId(int id);
    public List<Booking> findByNonMemberId(int id);
    //public Schedule findAllBySeatId(int scheduled);
    public List<Booking> findSeatByScheduledId(int scheduleId);
    public List<Booking> findByPayId(int payId);
    public List<Booking> findByLoginId(String loginId);
    public List<Booking> findByNonMemId(int phone);
    public List<BookingDTO> findByPayIdDTO(int payId);
    public List<Booking> findByNonMemPayId(int nonMemberId, int payId);
    public List<Booking> findValidByLoginId(String loginId);
    public List<Booking> findCancelByLoginId(String loginId);
    public List<BookingDTO> findByNonMemberIdToBookingDTO(int nonMemberId);
    public List<Integer> findOverBooking();
    public int timeOverBooking(int id);

}
