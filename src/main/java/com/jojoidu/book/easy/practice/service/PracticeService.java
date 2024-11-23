package com.jojoidu.book.easy.practice.service;

import com.jojoidu.book.easy.practice.dto.PracticeSubmitRequest;
import com.jojoidu.book.easy.practice.dto.PracticeSubmitResponse;
import com.jojoidu.book.easy.practice.dto.ProblemListResDto;
import com.jojoidu.book.easy.practice.dto.ProblemResponse;
import com.jojoidu.book.easy.practice.entity.Problem;
import com.jojoidu.book.easy.practice.entity.Solution;
import com.jojoidu.book.easy.practice.entity.SolveResult;
import com.jojoidu.book.easy.practice.exception.ProblemErrorCode;
import com.jojoidu.book.easy.practice.exception.ProblemException;
import com.jojoidu.book.easy.practice.exception.SolutionErrorCode;
import com.jojoidu.book.easy.practice.exception.SolutionException;
import com.jojoidu.book.easy.practice.repository.ProblemRepository;
import com.jojoidu.book.easy.practice.repository.SolutionRepository;
import com.jojoidu.book.easy.practice.repository.SolveResultRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PracticeService {

    private final ProblemRepository problemRepository;
    private final SolutionRepository solutionRepository;
    private final SolveResultRepository solveResultRepository;

    public ProblemResponse getProblemByStoreId(Long storeId) {
        Problem problem = problemRepository.findByStoreId(storeId)
                .orElseThrow(() -> new ProblemException(ProblemErrorCode.PROBLEM_NOT_FOUND));

        return new ProblemResponse(problem.getId(), problem.getProblem());
    }

    public PracticeSubmitResponse submitPractice(Long storeId, PracticeSubmitRequest request) {
        Solution solution = solutionRepository.findById(request.getProblemId())
                .orElseThrow(() -> new SolutionException((SolutionErrorCode.SOLUTION_NOT_FOUND)));

        List<PracticeSubmitRequest.Answer.Menu> submittedMenus = request.getAnswers().get(0).getMenus();
        List<Solution.AnswerEntity.MenuEntity> correctMenus = solution.getAnswers().get(0).getMenus();

        // 채점
        boolean menuResult = gradeMenuNames(submittedMenus, correctMenus);
        boolean optionResult = gradeOptions(submittedMenus, correctMenus);
        boolean amountResult = gradeQuantities(submittedMenus, correctMenus);

        // 결과 반환
        return new PracticeSubmitResponse(
                request.getProblemId(),
                menuResult,
                optionResult,
                amountResult
        );
    }

    /**
     * 메뉴 이름 채점
     *
     * @param submittedMenus 제출된 메뉴 리스트
     * @param correctMenus   정답 메뉴 리스트
     * @return 결과 (Boolean)
     */
    private boolean gradeMenuNames(List<PracticeSubmitRequest.Answer.Menu> submittedMenus,
                                   List<Solution.AnswerEntity.MenuEntity> correctMenus) {
        if (submittedMenus.size() != correctMenus.size()) {
            return false; // 메뉴 개수가 다르면 false
        }

        for (int i = 0; i < submittedMenus.size(); i++) {
            if (!submittedMenus.get(i).getMenuName().equals(correctMenus.get(i).getMenuName())) {
                return false; // 메뉴 이름이 하나라도 다르면 false
            }
        }

        return true; // 모두 일치하면 true
    }

    /**
     * 옵션 채점
     *
     * @param submittedMenus 제출된 메뉴 리스트
     * @param correctMenus   정답 메뉴 리스트
     * @return 결과 (Boolean)
     */
    private boolean gradeOptions(List<PracticeSubmitRequest.Answer.Menu> submittedMenus,
                                 List<Solution.AnswerEntity.MenuEntity> correctMenus) {
        if (submittedMenus.size() != correctMenus.size()) {
            return false; // 메뉴 개수가 다르면 false
        }

        for (int i = 0; i < submittedMenus.size(); i++) {
            List<PracticeSubmitRequest.Answer.Menu.OptionGroup> submittedOptions = submittedMenus.get(i).getSelectedOptions();
            List<Solution.AnswerEntity.MenuEntity.OptionGroupEntity> correctOptions = correctMenus.get(i).getSelectedOptions();

            if (submittedOptions.size() != correctOptions.size()) {
                return false; // 옵션 그룹 개수가 다르면 false
            }

            for (int j = 0; j < submittedOptions.size(); j++) {
                if (!submittedOptions.get(j).getOptionTitle().equals(correctOptions.get(j).getOptionTitle())) {
                    return false; // 옵션 제목이 하나라도 다르면 false
                }

                List<PracticeSubmitRequest.Answer.Menu.OptionGroup.Option> submittedOptionDetails = submittedOptions.get(j).getOptions();
                List<Solution.AnswerEntity.MenuEntity.OptionGroupEntity.OptionEntity> correctOptionDetails = correctOptions.get(j).getOptions();

                if (submittedOptionDetails.size() != correctOptionDetails.size()) {
                    return false; // 옵션 세부 항목 개수가 다르면 false
                }

                for (int k = 0; k < submittedOptionDetails.size(); k++) {
                    if (!submittedOptionDetails.get(k).getOptionName().equals(correctOptionDetails.get(k).getOptionName())) {
                        return false; // 옵션 이름이 하나라도 다르면 false
                    }
                }
            }
        }

        return true; // 모두 일치하면 true
    }

    /**
     * 수량 채점
     *
     * @param submittedMenus 제출된 메뉴 리스트
     * @param correctMenus   정답 메뉴 리스트
     * @return 결과 (Boolean)
     */
    private boolean gradeQuantities(List<PracticeSubmitRequest.Answer.Menu> submittedMenus,
                                    List<Solution.AnswerEntity.MenuEntity> correctMenus) {
        if (submittedMenus.size() != correctMenus.size()) {
            return false; // 메뉴 개수가 다르면 false
        }

        for (int i = 0; i < submittedMenus.size(); i++) {
            if (!submittedMenus.get(i).getMenuQuantity().equals(correctMenus.get(i).getMenuQuantity())) {
                return false; // 메뉴 수량이 하나라도 다르면 false
            }
        }

        return true; // 모두 일치하면 true
    }

    public ProblemListResDto getCompletedList(Long userId) {
        List<SolveResult> solveResults = solveResultRepository.findByUserId(userId).orElseThrow();
        return ProblemListResDto.from(solveResults);
    }
}