package poly.dto;

import java.util.Date;

/**
 * Lớp này là một Data Transfer Object (DTO)
 * dùng để chứa kết quả trả về từ câu truy vấn JPQL thống kê chia sẻ.
 */
public class ShareReportDTO {

    private String videoTitle;
    private Long shareCount;
    private Date firstShareDate;
    private Date lastShareDate;

    // Constructor này phải khớp với thứ tự các trường trong câu lệnh SELECT NEW
    public ShareReportDTO(String videoTitle, Long shareCount, Date firstShareDate, Date lastShareDate) {
        this.videoTitle = videoTitle;
        this.shareCount = shareCount;
        this.firstShareDate = firstShareDate;
        this.lastShareDate = lastShareDate;
    }

    // Getters
    public String getVideoTitle() {
        return videoTitle;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public Date getFirstShareDate() {
        return firstShareDate;
    }

    public Date getLastShareDate() {
        return lastShareDate;
    }
    
    // Bạn có thể thêm Setters nếu cần
}