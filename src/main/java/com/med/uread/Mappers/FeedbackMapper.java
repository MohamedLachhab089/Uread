package com.med.uread.Mappers;

import com.med.uread.Entities.Book;
import com.med.uread.Entities.Feedback;
import com.med.uread.Request_Response.FeedbackRequest;
import com.med.uread.Request_Response.FeedbackResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class FeedbackMapper {

    public Feedback toFeedback(FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .archived(false)
                        .shareable(false)
                        .build())
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer id) {
        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), id))
                .build();
    }
}
