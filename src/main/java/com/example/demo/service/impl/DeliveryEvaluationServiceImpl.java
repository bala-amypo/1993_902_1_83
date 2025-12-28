@Service
public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository repo;
    private final VendorRepository vendorRepo;
    private final SLARequirementRepository slaRepo;

    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository repo,
            VendorRepository vendorRepo,
            SLARequirementRepository slaRepo) {
        this.repo = repo;
        this.vendorRepo = vendorRepo;
        this.slaRepo = slaRepo;
    }

    public DeliveryEvaluation createEvaluation(DeliveryEvaluation eval) {

        Vendor vendor = vendorRepo.findById(eval.getVendor().getId())
                .orElseThrow();

        if (!vendor.getActive())
            throw new IllegalStateException("Only active vendors allowed");

        if (eval.getActualDeliveryDays() < 0)
            throw new IllegalArgumentException(">= 0");

        if (eval.getQualityScore() < 0 || eval.getQualityScore() > 100)
            throw new IllegalArgumentException("between 0 and 100");

        SLARequirement sla = slaRepo.findById(eval.getSlaRequirement().getId())
                .orElseThrow();

        eval.setMeetsDeliveryTarget(
                eval.getActualDeliveryDays() <= sla.getMaxDeliveryDays());

        eval.setMeetsQualityTarget(
                eval.getQualityScore() >= sla.getQualityThreshold());

        return repo.save(eval);
    }
}
